import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileManager {

	

	    public static void saveUsers(List<User> users, String filename) {
	        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
	            for (User user : users) {
	            	writer.println(user.getUsername() + "," + user.getPassword() + "," + user.getEmail());

	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static List<User> loadUsers(String filename) {
	        List<User> users = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;

	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    String username = parts[0];
	                    String password = parts[1];
	                    String email = parts[2];
	                    users.add(new User(username, password,email));
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return users;
	    }
	}
