package view;

//an api to build/develop gui in java
import java.awt.*;
//for event handling
import java.awt.event.*;
//api for gui components
import javax.swing.*;




//login view class which holds the GUI related stuff

public class LoginView {
	//main frame for the entire application 
	//object creation
	public JFrame LoginFrame=new JFrame();
	
	//array to hold the object in the sidebar
	public JButton sidebar[]= {
			new JButton("Dashboard             "),//Dashboard Button which has 3 buttons linked to 3 different window
			new JButton("Manage Vehicles      "),//button which directs the user to the window to manage vehicles details
			new JButton("Manage Client"),//JButton for managing client details(Update and delete)
			new JButton("Logout           "),// button which logs out the user
			new JButton("Exit               ")// close button
			};
	
	public JLabel title[]= {
			new JLabel("Dashboard"),
			new JLabel("Manage Vehicles"),
			new JLabel("Manage Client"),
			new JLabel("Logout"),
			new JLabel("Exit")
	};
	

	
	// array of JButtons
	public JButton dashboard[]= {
			new JButton("Add Client"),// index 0-leading to the form
			new JButton("Add Vehicle"),//index 1-leading to the form
			new JButton("Look up...")//index 2-leading to the search panel
	};
	
	//the main structure of the panel or parent panel
	JPanel structPanel=new JPanel();//panel creation
	//label for user name
	public JLabel userlabel=new JLabel("User name  :");
	//username text field
	public JTextField usertxt=new JTextField(15);
	//password label
	public JLabel passlabel=new JLabel("Password  :");
	//password textfield
	private JPasswordField  passtxt=new JPasswordField ();
	//login button
	private JButton loginbtn=new JButton("Login");
	//combo box array to hold two options for login
	public String[] type= {"Staff","Client"};// option one is staff (index 0), option 2 is client(index 1)
	public JComboBox<String> cBox=new JComboBox<String>();
	private int number=0;
	
	//home panel 
	public JPanel pHome=new JPanel();

	
	//this j panel is an array of jpanel which holds 3 indexes containing 3 parts of the Jframe
	public JPanel mainPanel[]= {
			new JPanel(),//This one is for sidebar
			new JPanel(),//This one is just for adding extra gui component to enhance the beauty
			new JPanel(),//this panel holds the content(major functionalities)
			};	

	
	public LoginView() throws ClassNotFoundException {
		
		//parent panel layout set to null
		structPanel.setLayout(null);
		//jPanel object for structure of the all panel
		JPanel sp=new JPanel();
		structPanel.setBounds(0,0,442,448);
		sp.setBounds(120,0,250,330);
	
		//layout is null
		sp.setLayout(null);
		//add the object to the gui
		structPanel.add(sp);
		//create a new object of type ImageIcon to hold the image
		ImageIcon brandLogo=new ImageIcon("brandlogo.png");
		JLabel brandLogo2=new JLabel();
		//assign the label and set the image 
		brandLogo2.setIcon(brandLogo);
		//add to the panel
		sp.add(brandLogo2);
		
		
		
		/*************
		 * this area is for login area
		 */
		
		
		//add username label
		structPanel.add(userlabel);		
		userlabel.setBounds(79,240,105,35);
		//add username textfield
		structPanel.add(usertxt);
		usertxt.setBounds(195,240,160,35);
		//add password label
		structPanel.add(passlabel);
		passlabel.setBounds(80,290,105,35);
		//add password text
		structPanel.add(passtxt);
		passtxt.setBounds(195,290,160,35);
		//add the object to the parent panel
		structPanel.add(sp);
		//the layout for the login area
		sp.setLayout(new GridLayout(2,5));
		//add the combo box for staff/client
		structPanel.add(cBox);
		cBox.setBounds(195,340,160,35);
	
		
		for(int i=0;i<type.length;i++)
			cBox.addItem(type[number++]);
		
		//add the button of login
		structPanel.add(loginbtn);
		loginbtn.setBounds(195, 395, 160, 35);

		
		

		/****************
		 * This is for sidebar				*
		 */
		ImageIcon imgIcon=new ImageIcon("userProfile.png");//sidebar image
		JLabel imgLogo=new JLabel();
		imgLogo.setIcon(imgIcon);//set the icon
		//add it to the panel index 0 which is for sidebar
		mainPanel[0].add(imgLogo);
		//50px on xaxis, 10 on y, width is 205px, height is 180px
		imgLogo.setBounds(50,10,205,180);
		
	
		//set the bg color of the sidebar
		mainPanel[0].setBackground((new Color(0.5f, 0.3f, 0.05f)));	
//		/sidebar position
		mainPanel[0].setBounds(0,0,215,710);
		mainPanel[0].setLayout(null);
		
		//add sidebar items depending on the sidebar array declared above
		for(int i=0;i<sidebar.length;i++) {
			mainPanel[0].add(sidebar[i]);
			
			//text position 
			sidebar[i].setHorizontalTextPosition(SwingConstants.CENTER);
			//custom bg color
			/**
			 * from
			 * https://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html
			 * */
			sidebar[i].setBackground(new Color(0.5f, 0.3f, 0.1f));
			//FONT COLOR 
			sidebar[i].setForeground(Color.white);
			
			//border of the sidebar objects
			/***
			 * from
			 * https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
			 */
			sidebar[i].setBorder(BorderFactory.createLoweredBevelBorder());
			
			
			
			//set the foreground of the title for each page
			title[i].setForeground(Color.white);
			
			//add the title objects
			mainPanel[1].add(title[i]);
			//if set to to true it will display all the label in one line and
			title[i].setVisible(false);//it will be a mess

		}
		//postion of the objects within the array of sidebar
		sidebar[0].setBounds(10,240,195,48);//index 0 position
		sidebar[1].setBounds(10,320,195,48);//index 1 position
		sidebar[2].setBounds(10,400,195,48);//index 2 position
		sidebar[3].setBounds(10,480,195,48);//index 3
		sidebar[4].setBounds(10,560,195,48);//index 4
	
		//position and bg color of the 2nd object of the mainPanel
		mainPanel[1].setBackground(new Color(0.5f, 0.3f, 0.05f));
		mainPanel[1].setForeground(Color.white);
		mainPanel[1].setBounds(215,0,800,40);
		mainPanel[1].setBorder(BorderFactory.createLoweredBevelBorder());
		
		
		
	//main content area which holds most of the functionalities
		mainPanel[2].setBounds(235,105,770,705);		
		
		//image icon for the buttons on the dashboard area
		ImageIcon icon[]= {
				new ImageIcon("addClientIcon.png"),
				new ImageIcon("addVehicleIcon.png"),
				new ImageIcon("searchVehicleIcon.png")
	};
		
		//set layout for the dashboard area
		pHome.setLayout(new GridLayout(3,5,3
				,5));
		mainPanel[2].setLayout(null);
		//content position of the dashboard panel within the content area
		pHome.setBounds(19,105,710,405);
		///if dashboard array length is greater than 0
		for(int i=0;i<dashboard.length;i++) {
			//add the dashboard panel of home
			pHome.add(dashboard[i]);
			//setIcon for each index of dashboard array
			dashboard[i].setIcon(icon[i]);
			icon[i].setDescription("Add Client");
			//Postion of the text would be on top of the icon
			dashboard[i].setVerticalTextPosition(SwingConstants.BOTTOM);
			//text centered
			dashboard[i].setHorizontalTextPosition(SwingConstants.CENTER); 
			dashboard[i].setBackground(new Color(0.5f, 0.3f, 0.2f));
			dashboard[i].setForeground(Color.WHITE);
			dashboard[i].setPreferredSize(new Dimension(400,300));
			
		}
		
		mainPanel[2].add(pHome);
		
		
		LoginFrame.setLayout(null);
		//not resizable
		LoginFrame.setResizable(false);
		LoginFrame.setSize(800,600);
		LoginFrame.setVisible(true);
		LoginFrame.setTitle("Northampton Vehicle Hire Company");
		
		
		
	
	}
	
	//method to add login area to the main structure
	public void addLoginView() {
		LoginFrame.setBounds(100,100,449,549);
		LoginFrame.add(structPanel);
		
		
	}
	
	public String getUser() {
		return usertxt.getText();
	}
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passtxt.getText();
	}
	public void loginListener(ActionListener a) {
		loginbtn.addActionListener(a);
	}
	
	//this method handles with the staff panel
	public void addStaffPage() {
		
		//for the main panel if i is less than the length of the array of main panel
		for(int i=0;i<mainPanel.length;i++) {
			
			//add the main content area 
			LoginFrame.setBounds(198,0,1005,753);
			LoginFrame.add(mainPanel[i]);
			structPanel.setVisible(false);

			
		}
		
	}
	
	
	
	//this method handles the navigation bar 
public void navBar(ActionListener a) {
		for(int i=0;i<dashboard.length;i++) {
			dashboard[i].addActionListener(a);
		}
		for(int i=0;i<sidebar.length;i++) {
			sidebar[i].addActionListener(a);
		}
		
	}
	
	
	
	
	


}
