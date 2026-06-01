package loginandregister;

import java.awt.Dimension;
import javax.swing.JLabel;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        String goToRegister = "<HTML> <u>Register now</u></HTML>";
        GoToRegister.setText(goToRegister);
        AppDescription.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RightPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AppDescription = new javax.swing.JTextArea();
        LeftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        GoToRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        RightPanel.setBackground(new java.awt.Color(254, 249, 231));
        RightPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/accounting.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 41, 59));
        jLabel5.setText("SpendSmart");

        AppDescription.setEditable(false);
        AppDescription.setBackground(new java.awt.Color(254, 249, 231));
        AppDescription.setColumns(20);
        AppDescription.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        AppDescription.setForeground(new java.awt.Color(30, 41, 59));
        AppDescription.setLineWrap(true);
        AppDescription.setRows(5);
        AppDescription.setText("Expense Tracker Application, a simple digital tool to track income, manage expenses, and plan finances efficiently.");
        AppDescription.setWrapStyleWord(true);
        AppDescription.setBorder(null);
        AppDescription.setCaretColor(new java.awt.Color(254, 249, 231));
        AppDescription.setFocusable(false);
        AppDescription.setOpaque(false);

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightPanelLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel6))
                    .addGroup(RightPanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightPanelLayout.createSequentialGroup()
                .addGap(0, 89, Short.MAX_VALUE)
                .addComponent(AppDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(AppDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        jPanel1.add(RightPanel);
        RightPanel.setBounds(0, 0, 400, 500);

        LeftPanel.setBackground(new java.awt.Color(30, 41, 59));
        LeftPanel.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        LeftPanel.setMinimumSize(new java.awt.Dimension(400, 500));
        LeftPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setBackground(new java.awt.Color(254, 249, 231));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 249, 231));
        jLabel1.setText("LOGIN");

        jLabel2.setBackground(new java.awt.Color(254, 249, 231));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 249, 231));
        jLabel2.setText("Username");

        UsernameField.setBackground(new java.awt.Color(254, 249, 231));
        UsernameField.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 13)); // NOI18N
        UsernameField.setForeground(new java.awt.Color(30, 41, 59));

        jLabel3.setBackground(new java.awt.Color(254, 249, 231));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 249, 231));
        jLabel3.setText("Password");

        PasswordField.setBackground(new java.awt.Color(254, 249, 231));
        PasswordField.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 13)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(30, 41, 59));
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        LoginButton.setBackground(new java.awt.Color(254, 249, 231));
        LoginButton.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(30, 41, 59));
        LoginButton.setText("LOGIN");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 249, 231));
        jLabel4.setText("Dont have account?");

        GoToRegister.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        GoToRegister.setForeground(new java.awt.Color(254, 249, 231));
        GoToRegister.setText("Register now");
        GoToRegister.setBorder(null);
        GoToRegister.setContentAreaFilled(false);
        GoToRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoToRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(126, 126, 126))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GoToRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(GoToRegister))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jPanel1.add(LeftPanel);
        LeftPanel.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void GoToRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoToRegisterActionPerformed
        Register registerFrame = new Register();
        registerFrame.setVisible(true);
        registerFrame.pack();
        registerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_GoToRegisterActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed

    String username = UsernameField.getText();
    String password = new String(PasswordField.getPassword()); 
    
    // the backend validator
    Backend.InputValidator validator = new Backend.InputValidator();
    
    // validate Username 
    int usernameStatus = validator.validateUsername(username);
    if (usernameStatus != 0) {
        switch (usernameStatus) {
            case 1:
                javax.swing.JOptionPane.showMessageDialog(this, "Username field cannot be empty.", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                javax.swing.JOptionPane.showMessageDialog(this, "Username must be between 5 and 15 characters.", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid characters detected.", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
        }
        return;
    }
    
    // validate Password 
    int passwordStatus = validator.validatePassword(password, password);
    if (passwordStatus != 0) {
        switch (passwordStatus) {
            case 1:
                javax.swing.JOptionPane.showMessageDialog(this, "Password field cannot be empty.", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                javax.swing.JOptionPane.showMessageDialog(this, "Password must be between 8 and 19 characters.", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
            case 4:
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid characters detected.", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                break;
        }
        return; 
    }
  
    // to hash
    javax.swing.JOptionPane.showMessageDialog(this, "Login successfully...", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
  
    }//GEN-LAST:event_LoginButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login frame = new Login();
                frame.setLocationRelativeTo(null); 
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AppDescription;
    private javax.swing.JButton GoToRegister;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}