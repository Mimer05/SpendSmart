
package Backend;

public class InputValidator {
    
   // all public method return interger //
    
    public int validatePassword(String pass, String confirmPass) {
        if (isFieldEmpty(pass, confirmPass))   return 1;
        if (isPasswordNotMatch(pass, confirmPass)) return 2;
        if (isPasswordLengthInvalid(pass))      return 3;
        if (hasSqlInjectionRisk(pass))          return 4;
        return 0;
    }

    private boolean isFieldEmpty(String... fields) {
        for (String field : fields) {
           if (field == null || field.trim().isEmpty()) return true;
        }
        return false;
    }

  
    private boolean isPasswordNotMatch(String pass, String confirm) {
        return !pass.equals(confirm);
    }

   //check for the password length
    private boolean isPasswordLengthInvalid(String pass) {
        return pass.length() <= 7 || pass.length() >= 20;
    }

    //this is for sql injection prevention
    private boolean hasSqlInjectionRisk(String text) {
        return text.contains("'")  ||
               text.contains("\"") ||
               text.contains(";")  ||
               text.contains("--") ||
               text.contains("/*") ||
               text.contains("*/") ||
               text.contains("<")  ||
               text.contains(">")  ||
               text.contains("(")  ||
               text.contains(")");
    }


    
    public int validateUsername(String username) {
        if (isFieldEmpty(username))           return 1;
        if (isUsernameLengthInvalid(username)) return 2;
        if (hasSqlInjectionRisk(username))     return 3; 
        if (isUsernameFormatInvalid(username)) return 4; 
        return 0;
    }

    private boolean isUsernameLengthInvalid(String user) {
        return user.length() <= 4 || user.length() >= 16;
    }

   
    private boolean isUsernameFormatInvalid(String user) {
        return !user.matches("^[a-zA-Z0-9_]+$");
    }

    
}
