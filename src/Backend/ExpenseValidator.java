package Backend;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class ExpenseValidator {

    private static final double MIN_AMOUNT = 1.00;
    private static final double MAX_AMOUNT = 1_000_000.00;
    private static final int MAX_DESCRIPTION_LENGTH = 100;
    private static final int MAX_DATETIME_LENGTH = 19;

    
    private static final String DATE_FORMAT_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";

    public static boolean validate(Expense expense) {
        if (expense == null) {
            return false;
        }

        return isIdValid(expense.getExpenseId())
                && isIdValid(expense.getUserId())
                && isIdValid(expense.getCategoryId())
                && isAmountValid(expense.getAmount())
                && isDescriptionValid(expense.getDescription())
                && isExpenseDateValid(expense.getExpenseDate())
                && isCreatedAtValid(expense.getCreatedAt());
    }

    
    public static boolean isIdValid(int id) {
        return id > 0;
    }

    public static boolean isAmountValid(double amount) {
        return (amount >= MIN_AMOUNT && amount <= MAX_AMOUNT);
    }

    
    public static boolean isDescriptionValid(String description) {
        if (description == null || description.isBlank() || description.length() > MAX_DESCRIPTION_LENGTH) {
            return false;
        }

        return !description.contains("'")
                && !description.contains("--")
                && !description.contains(";")
                && !description.contains("`");
    }


    public static boolean isExpenseDateValid(String date) {
        if(date == null || date.isBlank() || !date.matches(DATE_FORMAT_PATTERN)){
            return false;
        }
        
        try{
            LocalDate parseDate = LocalDate.parse(date);
            
            int month = parseDate.getMonthValue();
            int day = parseDate.getDayOfMonth();
            
            return (month >= 1 && month <= 12) && (day >= 1 && day <= 31);
        }
        
        catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isCreatedAtValid(String dateTime) {
        return dateTime != null
                && !dateTime.isBlank()
                && dateTime.length() <= MAX_DATETIME_LENGTH;
    }

    public static String getErrorMessage(Expense expense) {
        if (expense == null) return "Error: Expense object cannot be null.";

        if (!isIdValid(expense.getExpenseId())) return "Error: Invalid Expense ID. Must be a positive number.";
        if (!isIdValid(expense.getUserId())) return "Error: Invalid User ID. Must be a positive number.";
        if (!isIdValid(expense.getCategoryId())) return "Error: Invalid Category ID. Must be a positive number.";

        if (!isAmountValid(expense.getAmount())) {
            return String.format("Error: Invalid amount. Must be between %.2f and %.2f.", MIN_AMOUNT, MAX_AMOUNT);
        }

        if (!isDescriptionValid(expense.getDescription())) {
            return "Error: Invalid description. Must not be empty, exceed " + MAX_DESCRIPTION_LENGTH
                    + " characters, or contain restricted characters (' -- ; `).";
        }

        if (!isExpenseDateValid(expense.getExpenseDate())) return "Error: Invalid expense date format. Use 'yyyy-MM-dd' (e.g., 2024-12-31).";
        if (!isCreatedAtValid(expense.getCreatedAt())) return "Error: System timestamp error.";

        return "Valid";
    }
}
