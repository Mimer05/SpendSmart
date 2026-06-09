package Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {

    private Connection getConn() {
        return DatabaseConfig.getConnection();
    }
    
    private boolean resolveAndValidate(Expense expense) {
        CategoryManager cm = new CategoryManager();
        
        if (expense.getCategoryName() != null && !expense.getCategoryName().trim().isEmpty()) {
            String cleanName = expense.getCategoryName().trim();
            int resolvedId = cm.getCategoryIdByName(cleanName);
            
            if (resolvedId == -1) {
                cm.addCategory(cleanName);
                resolvedId = cm.getCategoryIdByName(cleanName);
            }
            expense.setCategoryId(resolvedId);
        }
        
        if (expense.getCategoryId() <= 0) return false;
        if (!ExpenseValidator.isAmountValid(expense.getAmount())) return false;
        if (!ExpenseValidator.isDescriptionValid(expense.getDescription())) return false;
        if (!ExpenseValidator.isExpenseDateValid(expense.getExpenseDate())) return false;
        
        return true;
    }

    public boolean addExpense(Expense expense) {
        if (!resolveAndValidate(expense)) {
            return false;
        }

        String sql = "INSERT INTO transactions (user_id, category_id, amount, description, expense_date, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = getConn();
        
        try {
            conn.setAutoCommit(false);
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, expense.getUserId());
                pstmt.setInt(2, expense.getCategoryId());
                pstmt.setDouble(3, expense.getAmount());
                pstmt.setString(4, expense.getDescription());
                pstmt.setString(5, expense.getExpenseDate());
                pstmt.setString(6, expense.getCreatedAt());
                
                pstmt.executeUpdate();
                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                return false;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    public int addExpenseAndGetId(Expense expense) {
        if (!resolveAndValidate(expense)) {
            return -1;
        }

        String sql = "INSERT INTO transactions (user_id, category_id, amount, description, expense_date, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = getConn();

        try {
            conn.setAutoCommit(false);
            try (PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setInt(1, expense.getUserId());
                pstmt.setInt(2, expense.getCategoryId());
                pstmt.setDouble(3, expense.getAmount());
                pstmt.setString(4, expense.getDescription());
                pstmt.setString(5, expense.getExpenseDate());
                pstmt.setString(6, expense.getCreatedAt());

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            conn.commit();
                            return generatedKeys.getInt(1);
                        }
                    }
                }
                conn.rollback();
                return -1;
            } catch (SQLException e) {
                conn.rollback();
                return -1;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            return -1;
        }
    }

    public boolean updateExpense(Expense expense) {
        if (expense.getCategoryName() != null && !expense.getCategoryName().trim().isEmpty()) {
            CategoryManager cm = new CategoryManager();
            String cleanName = expense.getCategoryName().trim();
            int resolvedId = cm.getCategoryIdByName(cleanName);
            if (resolvedId == -1) {
                cm.addCategory(cleanName);
                resolvedId = cm.getCategoryIdByName(cleanName);
            }
            expense.setCategoryId(resolvedId);
        }
        
        if (!ExpenseValidator.isAmountValid(expense.getAmount())) return false;
        if (!ExpenseValidator.isDescriptionValid(expense.getDescription())) return false;
        if (!ExpenseValidator.isExpenseDateValid(expense.getExpenseDate())) return false;

        String sql = "UPDATE transactions SET category_id = ?, amount = ?, description = ?, expense_date = ? "
                + "WHERE expense_id = ? AND user_id = ?";

        try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
            pstmt.setInt(1, expense.getCategoryId());
            pstmt.setDouble(2, expense.getAmount());
            pstmt.setString(3, expense.getDescription());
            pstmt.setString(4, expense.getExpenseDate());
            pstmt.setInt(5, expense.getExpenseId());
            pstmt.setInt(6, expense.getUserId());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Database Update Execution Completed. Rows modified: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("SQL Exception during Update operation: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteExpense(int expenseId, int userId) {
        String sql = "DELETE FROM transactions WHERE expense_id = ? AND user_id = ?";
        try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
            pstmt.setInt(1, expenseId);
            pstmt.setInt(2, userId);
            int rows = pstmt.executeUpdate();
            System.out.println("Expense deleted. Rows affected: " + rows);
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Delete expense failed: " + e.getMessage());
            return false;
        }
    }

    public List<Expense> getExpensesByUser(int userId) {
        List<Expense> expenses = new ArrayList<>();

        String sql = "SELECT t.expense_id, t.user_id, t.category_id, c.category_name, "
                + "t.amount, t.description, t.expense_date, t.created_at "
                + "FROM transactions t "
                + "JOIN categories c ON t.category_id = c.category_id "
                + "WHERE t.user_id = ? "
                + "ORDER BY t.expense_date DESC";

        try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Expense e = new Expense(
                            rs.getInt("expense_id"),
                            rs.getInt("user_id"),
                            rs.getInt("category_id"),
                            rs.getDouble("amount"),
                            rs.getString("description"),
                            rs.getString("expense_date"),
                            rs.getString("created_at")
                    );
                    e.setCategoryName(rs.getString("category_name"));
                    expenses.add(e);
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch expenses: " + e.getMessage());
        }

        return expenses;
    }

    public List<Category> getSummaryByCategory(int userId) {
        List<Category> summary = new ArrayList<>();

        String sql = "SELECT c.category_name, SUM(t.amount) AS total "
                + "FROM transactions t "
                + "JOIN categories c ON t.category_id = c.category_id "
                + "WHERE t.user_id = ? "
                + "GROUP BY c.category_name "
                + "ORDER BY total DESC";

        try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Category cat = new Category(
                            rs.getString("category_name"),
                            rs.getDouble("total")
                    );
                    summary.add(cat);
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch summary: " + e.getMessage());
        }

        return summary;
    }

    public double getTotalExpenses(int userId) {
        String sql = "SELECT SUM(amount) AS grand_total FROM transactions WHERE user_id = ?";
        try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("grand_total");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to get total expenses: " + e.getMessage());
        }
        return 0.0;
    }

}
