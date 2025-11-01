
public class Test {

	public static void main(String[]agrs) {
	   LoginModel model = new LoginModel();
       LoginView view = new LoginView();
       
       // Create controller
       LoginController controller = new LoginController(view, model);
}}
