import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class HomeController {

    private HomeView view;
    private User user;  

    public HomeController(User user) {
        this.user = user;  
        this.view = new HomeView(user.getUsername());

        this.view.addLogoutButtonListener(new LogoutButtonListener());
        this.view.addProfileButtonListener(new ProfileButtonListener());
        this.view.addSettingsButtonListener(new SettingsButtonListener());
        this.view.addSaveNotesButtonListener(new SaveNotesButtonListener());
        this.view.addKeyBoardListener(new HomeKeyListener());


    }

    public class LogoutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage("Logging out...");
            view.close();
        }
    }

    public class ProfileButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage(
                "👤 Username: " + user.getUsername() + "\n" +
                "📧 Email: " + user.getEmail()
            );
        }
    }

    public class SettingsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage("this feature is not avilable yet");
        }
    }
    
    public class SaveNotesButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String notes = view.getNotesText();

            try (FileWriter writer = new FileWriter("C:\\Users\\Fatima\\Desktop\\notes.txt")) {
                writer.write(notes);
                view.showMessage("Notes saved successfully!");
            } catch (IOException ex) {
                view.showMessage("Failed to save notes: " + ex.getMessage());
            }
        }
    }
    
 
    public class HomeKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
           
        	System.out.println("youre typing the note");
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	 if (e.getKeyCode() == KeyEvent.VK_F1) {
        	        view.showMessage("This is a cooking notes application.\nPress F2 to clear notes.\nPress Ctrl+S to save.");
        	    }
        }

        @Override
        public void keyReleased(KeyEvent e) {
             
        }
    }

}

