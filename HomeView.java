import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class HomeView {
    private JFrame frame;
    private JButton logoutButton;
    private JButton profileButton;
    private JButton settingsButton;
    private JTextArea notesArea;
    private JButton saveNotesButton;

    
    Color biege = new Color(240, 210, 200);
    Color darkPink = new Color(168, 112, 121);
    Color green = new Color(137, 207, 240);
    
    public HomeView(String username) {
        frame = new JFrame("Home - Welcome " + username);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        buildGUI(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buildGUI(Container pane) {
        pane.setBackground(biege);

        
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/roses.png")); 
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(biege);
        imagePanel.add(logoLabel, BorderLayout.CENTER);

        // Main content panel
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));
        contentPanel.setBackground(biege);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        
        JLabel welcomeLabel = new JLabel("rescepies cute and coquette");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(darkPink);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(welcomeLabel, gbc);
        
    
        notesArea = new JTextArea(10, 30);
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);
        notesArea.setFont(new Font("Arial", Font.PLAIN, 14));
        notesArea.setBorder(BorderFactory.createTitledBorder("📝 Your Notes"));
        notesArea.setBackground(biege);

        JScrollPane scrollPane = new JScrollPane(notesArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 150));
        scrollPane.setBackground(darkPink);

        
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        contentPanel.add(scrollPane, gbc);

     
        saveNotesButton = new JButton("Save Notes");
        saveNotesButton.setBackground(darkPink);
        saveNotesButton.setForeground(Color.white);
       
        
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(biege);

      
        profileButton = new JButton("Profile");
        profileButton.setBackground(darkPink);
        profileButton.setForeground(Color.WHITE);
        profileButton.setFocusPainted(false);
        buttonPanel.add(profileButton);

        // Settings button
        settingsButton = new JButton("Settings");
        settingsButton.setBackground(darkPink);
        settingsButton.setForeground(Color.WHITE);
        buttonPanel.add(settingsButton);

        // Logout button
        logoutButton = new JButton("Logout");
        logoutButton.setBackground(darkPink);
        logoutButton.setForeground(Color.WHITE);
        buttonPanel.add(logoutButton);
        buttonPanel.add(saveNotesButton);

        

        
        pane.add(imagePanel, BorderLayout.NORTH);
        pane.add(contentPanel, BorderLayout.CENTER);
        pane.add(buttonPanel, BorderLayout.SOUTH);
    }

   
    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getProfileButton() {
        return profileButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }

   
    public void addLogoutButtonListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }

    public void addProfileButtonListener(ActionListener listener) {
        profileButton.addActionListener(listener);
    }

    public void addSettingsButtonListener(ActionListener listener) {
        settingsButton.addActionListener(listener);
    }
    
    public void addSaveNotesButtonListener(ActionListener listener) {
        saveNotesButton.addActionListener(listener);
    }

  
    public void addKeyBoardListener(KeyListener listener) {
        frame.addKeyListener(listener);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void close() {
        frame.dispose();
    }

    public void show() {
        frame.setVisible(true);
    }

	public String getNotesText() {
		// TODO Auto-generated method stub
		return notesArea.getText();
}



	public void setNotesText(String text) {
		// TODO Auto-generated method stub
		 notesArea.setText(text);
	} 
}