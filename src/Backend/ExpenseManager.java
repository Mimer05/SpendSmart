package Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {

    private Connection getConn() {
        return DatabaseConfig.connection;
    }
    
    public boolean addExpense(Expense expense) {
        
        if (expense.getCategoryId() <= 0 && expense.getCategoryName() != null) {
            CategoryManager cm = new CategoryManager();
            int resolvedId = cm.getCategoryIdByName(expense.getCategoryName());
            if (resolvedId == -1) {
                System.out.println("Category not found: " + expense.getCategoryName());
                return false;
            }
            expense.setCategoryId(resolvedId);
        }

      
        if (!ExpenseValidator.isAmountValid(expense.getAmount())) {
            System.out.println(ExpenseValidator.getErrorMessage(expense));
            return false;
        }
        if (!ExpenseValidator.isDescriptionValid(expense.getDescription())) {
            System.out.println(ExpenseValidator.getErrorMessage(expense));
            return false;
        }
        if (!ExpenseValidator.isExpenseDateValid(expense.getExpenseDate())) {
            System.out.println(ExpenseValidator.getErrorMessage(expense));
            return false;
        }

        String sql = "INSERT INTO transactions (user_id, category_id, amount, description, expense_date, created_at) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
            pstmt.setInt(1, expense.getUserId());
            pstmt.setInt(2, expense.getCategoryId());
            pstmt.setDouble(3, expense.getAmount());
            pstmt.setString(4, expense.getDescription());
            pstmt.setString(5, expense.getExpenseDate());
            pstmt.setString(6, expense.getCreatedAt());
            pstmt.executeUpdate();
            System.out.println("Expense added successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println("Add expense failed: " + e.getMessage());
            return false;
        }
    }

   
    public boolean updateExpense(Expense expense) {
 
        if (expense.getCategoryId() <= 0 && expense.getCategoryName() != null) {
            CategoryManager cm = new CategoryManager();
            int resolvedId = cm.getCategoryIdByName(expense.getCategoryName());
            if (resolvedId == -1) {
                System.out.println("Category not found: " + expense.getCategoryName());
                return false;
            }
            expense.setCategoryId(resolvedId);
        }

        if (!ExpenseValidator.isAmountValid(expense.getAmount())) {
            System.out.println(ExpenseValidator.getErrorMessage(expense));
            return false;
        }
        if (!ExpenseValidator.isDescriptionValid(expense.getDescription())) {
            System.out.println(ExpenseValidator.getErrorMessage(expense));
            return false;
        }
        if (!ExpenseValidator.isExpenseDateValid(expense.getExpenseDate())) {
            System.out.println(ExpenseValidator.getErrorMessage(expense));
            return false;
        }

        String sql = "UPDATE transactions SET category_id = ?, amount = ?, description = ?, expense_date = ? "
                + "WHERE expense_id = ? AND user_id = ?";

        try (PreparedStatement pstmt = getConn().prepareStatement(sql)) {
            pstmt.setInt(1, expense.getCategoryId());
            pstmt.setDouble(2, expense.getAmount());
            pstmt.setString(3, expense.getDescription());
            pstmt.setString(4, expense.getExpenseDate());
            pstmt.setInt(5, expense.getExpenseId());
            pstmt.setInt(6, expense.getUserId());
            int rows = pstmt.executeUpdate();
            System.out.println("Expense updated. Rows affected: " + rows);
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Update expense failed: " + e.getMessage());
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
            ResultSet rs = pstmt.executeQuery();

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
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                    Category cat = new Category(
                    rs.getString("category_name"),  
                    rs.getDouble("total")          
                );
                summary.add(cat);
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
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("grand_total");
            }
        } catch (SQLException e) {
            System.out.println("Failed to get total expenses: " + e.getMessage());
        }
        return 0.0;
    }
}
