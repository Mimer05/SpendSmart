package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    private static final String URL = "jdbc:sqlite:spendsmart.db";
    public static Connection connection = null;

    public static void initialize() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);
            System.out.println("SQLite database initialized successfully.");
            
            createTables();

        } catch (SQLException e) {
            System.out.println("Database initialization failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
        System.out.println("SQLite Driver missing from classpath: " + e.getMessage());
        }
    }

    private static void createTables() {       
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                + "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "username TEXT NOT NULL UNIQUE,"
                + "password_hash TEXT NOT NULL,"
                + "password_salt TEXT NOT NULL"
                + ");";

        String createTransactionsTable = "CREATE TABLE IF NOT EXISTS transactions ("
                + "expense_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "user_id INTEGER NOT NULL,"
                + "category_id INTEGER NOT NULL,"
                + "amount REAL NOT NULL,"
                + "description TEXT NOT NULL,"
                + "expense_date TEXT NOT NULL,"
                + "created_at TEXT NOT NULL,"
                + "FOREIGN KEY (user_id) REFERENCES users(user_id)"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createTransactionsTable);
            System.out.println("Database schemas verified and ready.");
        } catch (SQLException e) {
            System.out.println("Table creation failed: " + e.getMessage());
        }
    }
}
