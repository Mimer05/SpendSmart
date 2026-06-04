package loginandregister;

import Backend.DatabaseConfig;

public class LoginAndRegister {

    public static void main(String[] args) {  
        DatabaseConfig.initialize();
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }
    
}
