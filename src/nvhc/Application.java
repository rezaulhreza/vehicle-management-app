package nvhc;



import javax.swing.*;

import model.*;
import view.*;
import controller.*;



public class Application {



	public static void main(String[] args)  throws ClassNotFoundException {
		
			LoginModel model=new LoginModel();
			LoginView login=new LoginView();
			login.addLoginView();
			LoginController controller=new LoginController(login,model);
			controller.login();
			JOptionPane.showMessageDialog(null, "Application launched!");

	}
	
}
