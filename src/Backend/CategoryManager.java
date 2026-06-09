package Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {

    private Connection getConn() {
        return DatabaseConfig.getConnection();
    }
   
    public boolean addCategory(String categoryName) {
    if (categoryName == null || categoryName.trim().isEmpty()) {
        System.out.println("Category name cannot be empty.");
        return false;
    }

    String sql = "INSERT OR IGNORE INTO categories (category_name) VALUES (?)";
    try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
        pstmt.setString(1, categoryName.trim());
        int rows = pstmt.executeUpdate();
        System.out.println("Category sync completed for: " + categoryName);
        return rows > 0;
    } catch (SQLException e) {
        System.out.println("Add category failed: " + e.getMessage());
        return false;
    }
}

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT category_id, category_name FROM categories ORDER BY category_name ASC";

        try (PreparedStatement pstmt = getConn().prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("category_name");
                categories.add(new Category(0, id, name));
            }

        } catch (SQLException e) {
            System.out.println("Failed to fetch categories: " + e.getMessage());
        }

        return categories;
    }
    
    public int getCategoryIdByName(String name) {
        String sql = "SELECT category_id FROM categories WHERE category_name = ?";
        try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
            pstmt.setString(1, name.trim());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("category_id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to find category: " + e.getMessage());
        }
        return -1;
    }
   
    public boolean deleteCategory(int categoryId) {
        String sql = "DELETE FROM categories WHERE category_id = ?";
        try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
            pstmt.setInt(1, categoryId);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Delete category failed: " + e.getMessage());
            return false;
        }
    }
}
