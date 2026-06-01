package loginandregister;

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
        String goToLogin = "<HTML><u>Login now</u></HTML>";
        GoToLogin.setText(goToLogin);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RegUsernameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        RegPassField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        RegConfirmPassField = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        GoToLogin = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/accounting.png"))); // NOI18N

        jLabel7.setText("jLabel7");

        LoginButton.setBackground(new java.awt.Color(254, 249, 231));
        LoginButton.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(30, 41, 59));
        LoginButton.setText("LOGIN");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTER");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(254, 249, 231));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/accounting.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 41, 59));
        jLabel9.setText("SpendSmart");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Expense Tracker Application, a simple digital tool to track income, manage expenses, and plan finances efficiently.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setFocusable(false);
        jTextArea1.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 90, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        jPanel3.setBackground(new java.awt.Color(30, 41, 59));

        jLabel2.setBackground(new java.awt.Color(254, 249, 231));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 249, 231));
        jLabel2.setText("Have account?");

        jLabel3.setBackground(new java.awt.Color(254, 249, 231));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 249, 231));
        jLabel3.setText("Register");

        RegUsernameField.setBackground(new java.awt.Color(254, 249, 231));
        RegUsernameField.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 13)); // NOI18N
        RegUsernameField.setForeground(new java.awt.Color(30, 41, 59));

        jLabel4.setBackground(new java.awt.Color(254, 249, 231));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 249, 231));
        jLabel4.setText("username");

        RegPassField.setBackground(new java.awt.Color(254, 249, 231));
        RegPassField.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 13)); // NOI18N
        RegPassField.setForeground(new java.awt.Color(30, 41, 59));

        jLabel5.setBackground(new java.awt.Color(254, 249, 231));
        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 249, 231));
        jLabel5.setText("Password");

        RegConfirmPassField.setBackground(new java.awt.Color(254, 249, 231));
        RegConfirmPassField.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 13)); // NOI18N
        RegConfirmPassField.setForeground(new java.awt.Color(30, 41, 59));

        jLabel8.setBackground(new java.awt.Color(254, 249, 231));
        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 249, 231));
        jLabel8.setText("Confirm Password");

        GoToLogin.setBackground(new java.awt.Color(255, 255, 255));
        GoToLogin.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        GoToLogin.setForeground(new java.awt.Color(254, 249, 231));
        GoToLogin.setText("Login now");
        GoToLogin.setBorder(null);
        GoToLogin.setContentAreaFilled(false);
        GoToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoToLoginActionPerformed(evt);
            }
        });

        RegisterButton.setBackground(new java.awt.Color(254, 249, 231));
        RegisterButton.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(30, 41, 59));
        RegisterButton.setText("REGISTER");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegUsernameField)
                    .addComponent(RegPassField)
                    .addComponent(RegConfirmPassField, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GoToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(RegUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegConfirmPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(GoToLogin))
                .addGap(38, 38, 38))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GoToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoToLoginActionPerformed
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_GoToLoginActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
     
    String username = RegUsernameField.getText();
    String password = new String(RegPassField.getPassword());
    String confirmPassword = new String(RegConfirmPassField.getPassword()); 
    
    //inputValidator
    Backend.InputValidator validator = new Backend.InputValidator();
    
    //validate Username
    int usernameStatus = validator.validateUsername(username);
    if (usernameStatus != 0) {
        switch (usernameStatus) {
            case 1:
                javax.swing.JOptionPane.showMessageDialog(this, "Username cannot be empty.", "Registration Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                javax.swing.JOptionPane.showMessageDialog(this, "Username must be between 5 and 15 characters.", "Registration Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid characters.", "Registration Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
        }
        return; 
    }
    
    // Password and Confirm Password
    int passwordStatus = validator.validatePassword(password, confirmPassword);
    if (passwordStatus != 0) {
        switch (passwordStatus) {
            case 1:
                javax.swing.JOptionPane.showMessageDialog(this, "Password fields cannot be empty.", "Registration Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                javax.swing.JOptionPane.showMessageDialog(this, "Passwords do not match.", "Registration Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                javax.swing.JOptionPane.showMessageDialog(this, "Password must be between 8 and 19 characters.", "Registration Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
            case 4:
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid characters.", "Registration Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
        }
        return; 
    }
    
    //PasswordSecurity class
    byte[] salt = Backend.PasswordSecurity.generateSalt();
    String secureHashedPassword = Backend.PasswordSecurity.hashPassword(password, salt);
    

    javax.swing.JOptionPane.showMessageDialog(this, "Register successfully", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
  
    }//GEN-LAST:event_RegisterButtonActionPerformed

   
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoToLogin;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField RegConfirmPassField;
    private javax.swing.JPasswordField RegPassField;
    private javax.swing.JTextField RegUsernameField;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}