package controller;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
//import all files from model
import model.*;
//import view from view package
import view.*;

public class LoginController {
	
	LoginView view;
	LoginModel model;
	
	//constructor for login controller, this is the parent class constructor
	public LoginController(LoginView view, LoginModel model) {
		
		this.view=view;
		this.model=model;
	}
	
	//login method where the action takes places
	//set to public to make it accessible for other class
	public void login() {
		
		//action listener for user login
		view.loginListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				//if user selects  staff it will call the check staff method from model and place
				//it into login view class and it will get the user details
				if(view.cBox.getSelectedItem().equals("Staff")) {
					//if the password matches with the one user enters in contrast to 
					//the password set on the check staff method 
					if (model.checkStaff(view.getUser(), view.getPassword())==true) {
						//it will then open the staff view and
						
						view.addStaffPage();
						//call the navigation menu for staff
						NavMenu();
					}
					else
						//display a message
						JOptionPane.showMessageDialog(null, "       Access Denied\nPlease enter correct credentials!",null, JOptionPane.WARNING_MESSAGE, null);

				}
				//if from the option , client is selected 
				else if (view.cBox.getSelectedItem().equals("Client")) {
					try {
						//first try this
						//check the method from model "checkClient"
						//
						if(model.checkClient(view.getUser(),
								//if password matches the text from customers.txt then give access
								view.getPassword())==true) {
							//get the Text from the txt file for client
							String client = view.usertxt.getText();
							//if matches then  release the window for that and all subcompononets
							//along with the child classes
							view.LoginFrame.dispose();
							//create a new object for client view and client controller
							ClientView cView  =new ClientView();
							ClientController cController = new ClientController(cView);
							//vall the client page method
							cView.ClientPage();
							//call the navigation bar for client
							cController.NavMenu(client);
						}
						else
							//display a message
							JOptionPane.showMessageDialog(null, "       Access Denied\nPlease enter correct credentials!",null, JOptionPane.WARNING_MESSAGE, null);

					} catch (HeadlessException | FileNotFoundException e) {
						// TODO: handle exception
						//display a message
						JOptionPane.showMessageDialog(null, "       File could not be found!",null, JOptionPane.WARNING_MESSAGE, null);

					}
				}
				
			}
		});
	}
	
	//this method deals with the navigation for the user
	public void NavMenu() {
		view.navBar(new ActionListener() {
			
			@Override
			//this will invoke an action when all these 
			//options are clicked from the index
			public void actionPerformed(ActionEvent a) {
				//if invoked action is on the first index
				if (a.getSource()==view.sidebar[0]) {
					//it will remove the contents of this container
					view.mainPanel[2].removeAll();	
					//it will the repaint the container with the
					//components from below
					view.mainPanel[2].repaint();
					//add this component to the home panel
					view.mainPanel[2].add(view.pHome);
					// the re-validate  method informs the
					//layout manager to make  the layout valid again  
					//which is necessary when adding components.
					view.mainPanel[2].revalidate();
					
					//set the title for index 0(dashboard)
					for(int i=0;i<5;i++) {
						view.title[i].setVisible(false);
						view.title[0].setVisible(true);
					}
				}else if(a.getSource()==view.sidebar[1]) {
					
					//if the second index is selected then all the 3 panel will be
					//removed
					  view.mainPanel[2].removeAll();
					  //it will then repaint the component where
					  view.mainPanel[2].repaint();
					  //search view for vehicles components are added
					  SearchViewForVehicles searchVehiclesView=new SearchViewForVehicles();
					  //object instance for controller is created
					  SearchControllerForVehicles searchVehicleController=new SearchControllerForVehicles(searchVehiclesView);
					  //add record method is called
					  searchVehicleController.addRecord();
					  //display the vehicles from vehicles.txt
					  //this method will deal with this
					  searchVehicleController.ShowResultForVehicle();
					  //for the array side which deals wiht the title of each window

					//in the parent panel the position of the tables will be set to this position
					searchVehiclesView.structPanel.setBounds(0, 0, 650, 650);
					//add this to the panel
					view.mainPanel[2].add(searchVehiclesView.structPanel);
					view.mainPanel[2].revalidate();
					
					//set the title for index 1
					for(int i=0;i<5;i++) {
						view.title[i].setVisible(false);
						view.title[1].setVisible(true);
					}
					
				}
				
				else if(a.getSource()==view.sidebar[2]) {
					//if the 3rd index is selected then all the 3 panel will be
					//removed
					  view.mainPanel[2].removeAll();
					//it will then repaint the component where
					  view.mainPanel[2].repaint();
					//search view for client components are added
					  SearchViewForClient searchClientView=new SearchViewForClient();
					//search controller for client components are added
					  SearchControllerForClient searchClientController=new SearchControllerForClient(searchClientView);
					  //call the method add record
					  searchClientController.addRecord();
					  //display client details
					  searchClientController.ShowResultForClient();

					  //set the position
					  searchClientView.structPanel.setBounds(0, 0, 650, 650);
					  //add the view to the panel
					  view.mainPanel[2].add(searchClientView.structPanel);
					  view.mainPanel[2].revalidate();
					  
					//set the title for index 2
						for(int i=0;i<5;i++) {
							view.title[i].setVisible(false);
							view.title[2].setVisible(true);
						}
					
				}
				//if the 3rd index is selected then user will be logged out of the system 
				
				else if(a.getSource()==view.sidebar[3]) {
					//login method will be called
					
					view.LoginFrame.dispose();// the window for login area is released
					LoginView login;
					try {
						
						//set the title for index 3
						
						view.mainPanel[1].add(view.title[3]);
						for(int i=0;i<5;i++) {
							view.title[i].setVisible(false);
							view.title[3].setVisible(true);
						}
						
						//create a new instance of login view
						login = new LoginView();
						//call the add login view method from the view
						login.addLoginView();
						 //calling login model by creating an instance of the 
						//login model class
						LoginModel model=new LoginModel();
						//instance of the login controller
						LoginController controller=new LoginController(login,model);
						controller.login();
						

		
					} catch (ClassNotFoundException e) {
						
					}
					
					
				}
				//this is the last index
				//when this is clicked
				else if(a.getSource()==view.sidebar[4]) {
					//program closes
					System.exit(0);
				}
				
				
				
				//action invokes when add client is clicked which is index 0
				else if(a.getSource()==view.dashboard[0]) {
					//remove all the components
					view.mainPanel[2].removeAll();
					//repaint this component
					view.mainPanel[2].repaint();
					 //create an instance of the addclientview class
					AddClientView addCV=new AddClientView(null, null, null, null, null, null, null, null, null);
					//create instance of the model
					AddClientModel addCM=new AddClientModel();
					//instance of the controller
					AddClientController addCC=new AddClientController(addCV,addCM);
					//include this  to the add client method
					addCC.AddClient();

					  //set the object postion which is the form (Add client view)
					  addCV.structPanel.setBounds(40, 15, 395, 494);
					  //add this to the panel
					  view.mainPanel[2].add(addCV.structPanel);
					  //validate the component
					  view.mainPanel[2].revalidate();
					  
					//set the title for each dashboard objects
					  
						for(int i=0;i<5;i++) {
							view.title[i].setVisible(false);
							//if dashboard index is selected then
							view.title[2].setVisible(true);//set the title for the page
							//JButton (Add Client) 
						}
					
				}
				
				else if(a.getSource()==view.dashboard[1]) {
					//remove all the components
					view.mainPanel[2].removeAll();
					view.mainPanel[2].repaint();
					 //create instance of add vehicle view class
					AddVehicleView addVV=new AddVehicleView(null, null, null, null, null, null, null, null, null, null, null);
					//instance of model
					AddVehicleModel addVM=new AddVehicleModel();
					//controller instance
					AddVehicleController addVC=new AddVehicleController(addVV,addVM);
					//call save record method from controller to store the vehicle details
					addVC.addVehicle();
					  addVV.structPanel.setBounds(50, 10,400, 500);
					  view.mainPanel[2].add(addVV.structPanel);
					  view.mainPanel[2].revalidate();
					  
						//set the title for each dashboard objects
					  
						for(int i=0;i<5;i++) {
							view.title[i].setVisible(false);
							//if dashboard index is selected then
							view.title[1].setVisible(true);//set the title for the page
							//JButton (Add Vehicle) 
						}
					
				}
				
				else if(a.getSource()==view.dashboard[2]) {
					view.mainPanel[2].removeAll();
					  view.mainPanel[2].repaint();
					  //instance of vehicles class
					  SearchViewForVehicles searchVehiclesView=new SearchViewForVehicles();
					  SearchControllerForVehicles searchControllerForVehicles=new SearchControllerForVehicles(searchVehiclesView);
					  searchControllerForVehicles.ShowResultForVehicle();
					view.mainPanel[2].setLayout(null);
					searchVehiclesView.searchPanel.setBounds(0, 0, 650, 90);
					view.mainPanel[2].add(searchVehiclesView.searchPanel);
					searchVehiclesView.structPanel.setBounds(0, 100, 750, 600);
					view.mainPanel[2].add(searchVehiclesView.structPanel);
					view.mainPanel[2].revalidate();
					
					//set the title for each dashboard objects
					  
					for(int i=0;i<5;i++) {
						view.title[i].setVisible(false);
						//if dashboard index is selected then
						view.title[1].setVisible(true);//set the title for the page
						//JButton (Add Vehicle) 
					}
				
				}
			}
		});
}
		
	
	
}