import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView {

    private JFrame frame;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JCheckBox showPWButton;
    private JButton loginButton;
    private JCheckBox themeToggle;//+++ new 
    private JButton signUpButton; //+++ new
    private JButton forgotPWButton;//+++ new 
    private JTextField emailField; //+++ new 
    private JCheckBox rulesButton; //+++ new 
    
    
       //+++ new 
    Color biege = new Color(240, 210, 200);
    Color dustyrose = new Color(200, 150, 160);
    Color darkPink = new Color(168, 112, 121);
    Color Violet = new Color(75, 60, 80);
    Color green = new Color(245, 230, 220);
    //Color voilet = new Color(148, 0, 211);
    
    public LoginView(){
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        buildGUI(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buildGUI(Container pane) {
     
        pane.setBackground(biege);

        //+++new 
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/roses.png")); 
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(biege);
        imagePanel.add(logoLabel, BorderLayout.CENTER);
       

        // form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));
        formPanel.setBackground(biege);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // email +++++
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(darkPink);
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(emailLabel, gbc);

        emailField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0;
        formPanel.add(emailField, gbc);

        // username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(darkPink);
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(userLabel, gbc);

        userNameField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        formPanel.add(userNameField, gbc);

        // password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(darkPink);
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(passLabel, gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 2;
        formPanel.add(passwordField, gbc);

        // Show Password
        showPWButton = new JCheckBox("Show password");
        showPWButton.setBackground(biege);
        showPWButton.setForeground(darkPink);
        gbc.gridx = 1; gbc.gridy = 3;
        formPanel.add(showPWButton, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10)); //automatic
        buttonPanel.setBackground(biege);

        loginButton = new JButton("Login");
        loginButton.setBackground(darkPink);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 13));
        buttonPanel.add(loginButton);

         //sign up ++++
        signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(darkPink);
        signUpButton.setForeground(Color.WHITE);
        buttonPanel.add(signUpButton);
          
         //++++++++
        forgotPWButton = new JButton("Forgot Password?");
        forgotPWButton.setBackground(darkPink);
        forgotPWButton.setForeground(Color.WHITE);
        buttonPanel.add(forgotPWButton);
        
        themeToggle = new JCheckBox("Dark Mode");
        themeToggle.setBackground(biege);
        rulesButton = new JCheckBox("read rules");
        rulesButton.setBackground(biege);
        
       
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 30)); //top, left, bottom , right
        
       
        westPanel.setBackground(biege);
        westPanel.add(themeToggle);
        westPanel.add(Box.createVerticalStrut(5));
        westPanel.add(rulesButton);


        // 
        pane.add(imagePanel, BorderLayout.NORTH);
        pane.add(westPanel, BorderLayout.WEST);
        pane.add(formPanel, BorderLayout.CENTER);
        pane.add(buttonPanel, BorderLayout.SOUTH);
    }

    // getters
    public String getUsername() {
        return userNameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getEmail() {
        return emailField.getText();
    }

    public JCheckBox getShowPasswordCheckbox() {
        return showPWButton;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
    
    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }
    
    public JButton getforgotPWButton() {
        return forgotPWButton; 
    }

    public JCheckBox getThemeToggle() {
        return themeToggle;
    }

    // listener Setters
    public void addLoginButtonListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
    public void addShowPasswordListener(ActionListener listener) {
        showPWButton.addActionListener(listener);
    }
    //new++++
    public void addrulesButton(ActionListener listener) {
    	rulesButton.addActionListener(listener);
    }
    //new++++
    public void addSignUpButtonListener(ActionListener listener) {
        signUpButton.addActionListener(listener);
    }
    //new +++++
    public void addForgotPasswordButtonListener(ActionListener listener) {
        forgotPWButton.addActionListener(listener);
    }
     //new++++
    public void addMouseListener(MouseListener listener) {
    	loginButton.addMouseListener(listener);
    	forgotPWButton.addMouseListener(listener);
    	signUpButton.addMouseListener(listener);
    }
 
     //new+++
    public void addWindowListener(WindowListener listener)
    {
    	frame.addWindowListener(listener);
    }
      //new +++++
    public void addThemeToggleListener(ActionListener listener) 
    {
    	themeToggle.addActionListener(listener);
    	
    }
    
    public boolean isThemeToggleSelected() {
        return themeToggle.isSelected();
    }
    
    public void greenmode() 
    {
    	frame.setBackground(green);
    	//themeToggle.setBackground(green);
    	//showPWButton.setBackground(green);
    	signUpButton.setBackground(green);
    	loginButton.setBackground(green);
    	forgotPWButton.setBackground(green);
    	
    	//setBackground(green);
    	
    }
    
    public void pinkmode() 
    {
    	//frame.setBackground(green);
    	//themeToggle.setBackground(green);
    	//showPWButton.setBackground(darkPink);
    	signUpButton.setBackground(darkPink);
    	loginButton.setBackground(darkPink);
    	forgotPWButton.setBackground(darkPink);
    	
    	//setBackground(green);
    	
    }
    
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
    public boolean isShowPasswordSelected() {
        return showPWButton.isSelected();
    }
    
    public void showPassword() {
        passwordField.setEchoChar((char) 0);
    }
    
    public void hidePassword() {
        passwordField.setEchoChar('*'); 
    }

    // ++++
    public void close() {
        frame.dispose();
    }

	
}

