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

    public Expense(int expenseId, int userId, int categoryId, double amount, String description, String expenseDate) {
        this.expenseId = expenseId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.description = description;
        this.expenseDate = expenseDate;

        LocalDateTime dateAndTimeNow = LocalDateTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.createdAt = dateAndTimeNow.format(formatTime);
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
    
    
    
    public void setCategoryId(int categoryid){
        this.categoryId = categoryid;
    }
    
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setExpenseDate(String expensedate){
        this.expenseDate = expensedate;
    }
    
}
