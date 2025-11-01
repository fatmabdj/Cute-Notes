import java.util.ArrayList;
import java.util.List;

public class LoginModel {

    private List<User> users = new ArrayList<>();

    public LoginModel() {
         
        users.add(new User("admin", "1234", "admin@gmail.com"));
        users.add(new User("fatima","meow","fatima@gamil.com"));
        users.add(new User("loki","pokie","wookie@gamil.com"));
        UserFileManager.saveUsers(users, "C:\\Users\\Fatima\\Desktop\\users.txt"); 
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) &&
                user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean SingUp(String username, String password, String email) {
        
        for (User user : users) {
            if (user.getUsername().equals(username) || user.getPassword().equals(password)) {
                return false;  
            }
        }
        
        users.add(new User(username, password, email));

       
        UserFileManager.saveUsers(users,"C:\\Users\\Fatima\\Desktop\\users.txt");  

        return true;  
    }

    public boolean delete(String username, String password, String email) {
        for (User user : users) {
            if (user.getUsername().equals(username) &&
                user.getPassword().equals(password) &&
                user.getEmail().equals(email)) {
                users.remove(user);
                UserFileManager.saveUsers(users,"C:\\Users\\Fatima\\Desktop\\users.txt");  
                return true;
            }
        }
        return false;
    }

	@Override
	public String toString() {
		return "LoginModel [users=" + users + "]";
	}
    
}