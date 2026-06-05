package Backend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense {
    private int expenseId;
    private int userId;
    private int categoryId;
    private double amount;
    private String description;
    private String expenseDate;
    private String createdAt;
    private String categoryName;

    private static final DateTimeFormatter FORMAT_TIME =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

   
    public Expense(int expenseId, int userId, int categoryId, double amount,
                   String description, String expenseDate, String createdAt) {
        this.expenseId = expenseId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.description = description;
        this.expenseDate = expenseDate;
        this.createdAt = createdAt;
    }

    public Expense(int expenseId, int userId, int categoryId, double amount,
                   String description, String expenseDate) {
        this(expenseId, userId, categoryId, amount, description, expenseDate,
                LocalDateTime.now().format(FORMAT_TIME));
    }

    public Expense(int userId, int categoryId, double amount,
                   String description, String expenseDate) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.description = description;
        this.expenseDate = expenseDate;
        this.createdAt = LocalDateTime.now().format(FORMAT_TIME);
    }

   
    public Expense(int userId, String categoryName, double amount,
                   String description, String expenseDate) {
        this.userId = userId;
        this.categoryName = categoryName;
        this.amount = amount;
        this.description = description;
        this.expenseDate = expenseDate;
        this.createdAt = LocalDateTime.now().format(FORMAT_TIME);
    }

    public int getExpenseId() {
        return expenseId; 
    }
    public int getUserId() {
        return userId; 
    }
    public int getCategoryId() { 
        return categoryId; 
    }
    public double getAmount() {
        return amount; 
    }
    public String getDescription() {
        return description; 
    }
    public String getExpenseDate() {
        return expenseDate; 
    }
    public String getCreatedAt() { 
        return createdAt; 
    }
    public String getCategoryName() { 
        return categoryName;
    }

    public void setExpenseId(int expenseId) { 
        this.expenseId = expenseId; 
    }
    public void setCategoryId(int categoryId) { 
        this.categoryId = categoryId; 
    }
    
    public void setCategoryName(String categoryName) { 
        this.categoryName = categoryName;
    }
    
    public void setAmount(double amount) { 
        this.amount = amount; 
    }
    public void setDescription(String description) {
        this.description = description; 
    }
    public void setExpenseDate(String expenseDate) { 
        this.expenseDate = expenseDate; 
    }
}
