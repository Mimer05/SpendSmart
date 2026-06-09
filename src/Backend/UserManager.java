package Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class UserManager {

    private InputValidator validator = new InputValidator();

    public static final int ERR_EMPTY_FIELD = -1;
    public static final int ERR_INVALID_USERNAME = -2;
    public static final int ERR_INVALID_FORMAT = -3;
    public static final int ERR_USER_NOT_FOUND = -4;
    public static final int ERR_WRONG_PASSWORD = -5;
    public static final int ERR_DATABASE = -6;
    
    public int registerUser(String username, String password, String confirmPass) {
        System.out.println("Checking username: " + username + "....");

        int userCheck = validator.validateUsername(username);
        if (userCheck != 0) {
            System.out.println("There's an error in username: Code " + userCheck);
            return -userCheck;
        }

        int passCheck = validator.validatePassword(password, confirmPass);
        if (passCheck != 0) {
            System.out.println("There's an error in password: Code " + passCheck);
            return -passCheck;
        }

        byte[] userSaltBytes  = PasswordSecurity.generateSalt();
        String userSaltBase64 = Base64.getEncoder().encodeToString(userSaltBytes);
        String passwordHash   = PasswordSecurity.hashPassword(password, userSaltBytes);

        String sql = "INSERT INTO users (username, password_hash, password_salt) VALUES (?, ?, ?)";

        Connection conn = DatabaseConfig.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, passwordHash);
            pstmt.setString(3, userSaltBase64);
            pstmt.executeUpdate();
            System.out.println("User '" + username + "' registered successfully.");
            return 0;
        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
            return -1;
        }
    }

    
    public int loginUser(String username, String password) {
        System.out.println("Attempting login for: " + username + "....");

        int userCheck = validator.validateUsername(username);
        if (userCheck != 0) {
            System.out.println("There's an error in username: Code " + userCheck);
            return -userCheck;
        }

        int passCheck = validator.validatePassword(password);
        if (passCheck != 0) {
            System.out.println("There's an error in password: Code " + passCheck);
            return -passCheck;
        }

        
        String sql = "SELECT user_id, password_hash, password_salt FROM users WHERE username = ?";

        Connection conn = DatabaseConfig.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("Login failed: user not found.");
                    return ERR_USER_NOT_FOUND;
                }

                int    userId        = rs.getInt("user_id");
                String storedHash    = rs.getString("password_hash");
                String storedSaltB64 = rs.getString("password_salt");

               
                byte[] saltBytes = Base64.getDecoder().decode(storedSaltB64);
                boolean isMatch  = PasswordSecurity.verifyPassword(password, saltBytes, storedHash);

                if (isMatch) {
                    System.out.println("Login successful for: " + username);
                    return userId;  
                } else {
                    System.out.println("Login failed: incorrect password.");
                    return ERR_WRONG_PASSWORD;
                }
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
            return ERR_DATABASE;
        }
    }

    public String getUsernameById(int userId) {
        String sql = "SELECT username FROM users WHERE user_id = ?";
        try (PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("username");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch username: " + e.getMessage());
        }
        return null;
    }
}