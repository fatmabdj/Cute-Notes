import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LoginController {

    private LoginView view;
    private LoginModel model;

    Color biege = new Color(240, 210, 200);
    Color darkPink = new Color(168, 112, 121);
    Color purePink = new Color(255,192,203);

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
        this.view.addLoginButtonListener(new LoginButtonListener());
        this.view.addSignUpButtonListener(new SignUpButtonListener()); //1
        this.view.addForgotPasswordButtonListener(new ForgotPasswordListener());//2
        this.view.addShowPasswordListener(new ShowPasswordListener());
        this.view.addWindowListener(new LoginWindowListner());//3
        this.view.addMouseListener(new LoginMouseListener());//4
        this.view.addThemeToggleListener(new ThemeToggleListener());//5
        this.view.addrulesButton(new RulesListener());//6
        
       
    }
    
    class ThemeToggleListener implements ActionListener 
    {   @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
    	if(view.isThemeToggleSelected()==true)
			view.greenmode();
    	else
    		view.pinkmode();
			
		}
    	
    }
    class LoginMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
				view.greenmode();
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			view.pinkmode();
		
		}}
    class LoginWindowListner implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Login window opened");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Login window is closeing...");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Login window is closed");
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Login window is Activated");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}}
    

   
    class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (model.login(username, password)) {
                view.showMessage("Login successful!");
                login(); 
            } else {
                view.showMessage("Invalid username or password!");
            }
        }
    }
    
    class RulesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.showMessage("Be nice and polite \n enjoy :) ");
		}
    	
    }


     
    class SignUpButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();
            String email = view.getEmail();

            if (model.SingUp(username, password, email)) {
                view.showMessage("Sign Up successful :D");
                   
            } else {
                view.showMessage("Username or Email already exists :<");
            }
        }
    }
    
   
    class ForgotPasswordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage("Please contact support for password recovery.");
        }
    }

     
    class ShowPasswordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.isShowPasswordSelected()) {
            	
                view.showPassword();
            } else {
                view.hidePassword();
            }
        }
    }
    
    private void login() {
        String username = view.getUsername();
        String password = view.getPassword();
        String email    = view.getEmail();
        if (model.login(username, password)) {
            view.showMessage("Login successful!!!<3333");
            new HomeController(new User(username,password,email));
           // homepage.setvisible(true);
        } else {
            view.showMessage("Invalid credentials. Please try again. :<");
        }
    }
}