package loginandregister;

import Backend.DatabaseConfig;

public class LoginAndRegister {

    public static void main(String[] args) {  
      
        DatabaseConfig.initialize();
        Login loginFrame = new Login(); 
        loginFrame.pack();                  
        loginFrame.setLocationRelativeTo(null); 
        loginFrame.setVisible(true);
    }
    
}
