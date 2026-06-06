package Backend;

public class Category {
    private int categoryId;
    private int userId;
    private String name;
    private double totalAmount; 

    public Category(int userId, int categoryId, String name) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Category(String name) {
        this.userId = 0; 
        this.name = name;
    }

    public Category(String name, double totalAmount) {
        this.name = name;
        this.totalAmount = totalAmount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public String getCategoryName() {
        return name;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

   
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}