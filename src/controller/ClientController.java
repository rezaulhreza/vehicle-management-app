package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import model.LoginModel;
import view.*;

public class ClientController {
	/**
	 * 
	 */
	
	//client view obejct of client view class
	ClientView view;
	public ClientController(ClientView view) {
		//constructor
		this.view=view;
	}


	public void NavMenu(String client) {
		//method for client anvigation bar
		view.navBar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				// iff index 0 or dashboard is selected
				if(a.getSource()==view.sidebar[0]) {
					
					//remove all the previous components
					view.mainPanel[2].removeAll();
					//redesign the content panel with the new one
					view.mainPanel[2].repaint();
					
					//add the panel to dashboard area
					view.mainPanel[2].add(view.pHome);
					view.mainPanel[2].revalidate();
					//set the title for index 0(dashboard)
					for(int i=0;i<5;i++) {
						view.title[i].setVisible(false);
						view.title[0].setVisible(true);
					}
				}
				else if(a.getSource()==view.sidebar[1]) {
					//prompt message
					JOptionPane.showMessageDialog(null, 
					"                   Important\nIf you have rented a vehicle and would like to return,\nPlease type 'Available' in the 'Hired by' Column and \nClick on 'Update'!");
					
					view.mainPanel[2].removeAll();
					view.mainPanel[2].repaint();
					//instance of vehicles details view
					SearchViewForVehicles searchViewForVehicles  = new SearchViewForVehicles();
					//instance of controller and assign the view in it
					SearchControllerForVehicles searchControllerForVehicles = new SearchControllerForVehicles(searchViewForVehicles);
					searchControllerForVehicles.ShowResultForVehicle();
					//call the method and assign it to controller
					searchControllerForVehicles.addClientRow(client);
					
					//make the button available for client
					searchViewForVehicles.updateVehicle.setEnabled(true);
					searchViewForVehicles.removeVehicle.setEnabled(false);
					searchViewForVehicles.structPanel.setBounds(0,0,745,695);
					view.mainPanel[2].add(searchViewForVehicles.structPanel);
					view.mainPanel[2].revalidate();
					//set the title for index 1
					for(int i=0;i<5;i++) {
						view.title[i].setVisible(false);
						view.title[1].setVisible(true);
					}
				}
				
				//if the second index(Manage details is selected
				else if(a.getSource()==view.sidebar[2]) {
					  view.mainPanel[2].removeAll();
					  view.mainPanel[2].repaint();
					  //instance of the view class
					  SearchViewForClient searchViewForClient=new SearchViewForClient();
					  //controller class instance
					  SearchControllerForClient scc=new SearchControllerForClient(searchViewForClient);
					  //call the method and assign with client
					  scc.addRowClient(client);
					  //from controller display client details
					  scc.ShowResultForClient();

					  searchViewForClient.structPanel.setBounds(0, 0, 750, 700);
					  view.mainPanel[2].add(searchViewForClient.structPanel);
					  //set the id enabled
					  searchViewForClient.removeClient.setEnabled(false);
					  searchViewForClient.updateClient.setEnabled(true);
					  view.mainPanel[2].revalidate();
					//set the title for index 2
						for(int i=0;i<5;i++) {
							view.title[i].setVisible(false);
							view.title[2].setVisible(true);
						}
					
				}
				else if(a.getSource()==view.sidebar[3]) {
					view.clientView.dispose();
					LoginView login;
					try {

						view.mainPanel[1].add(view.title[3]);
						for(int i=0;i<5;i++) {
							view.title[i].setVisible(false);
							view.title[3].setVisible(true);
						}
						
						login = new LoginView();
						login.addLoginView();
						 /*calling another class panel to add*/
						LoginModel model=new LoginModel();
						LoginController controller=new LoginController(login,model);
						controller.login();
						

		
					}
					//catch the exception
					catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(null, "File missing!",null, JOptionPane.WARNING_MESSAGE, null);
						
					}
					
					
				}
				else if(a.getSource()==view.sidebar[4]) {
					System.exit(0);
				}
				
				else if(a.getSource()==view.dashboard) {
					//prompt this
					JOptionPane.showMessageDialog(null,
					"                Important"
					+ "\nIf you want to hire any vehicle\n"
					+ "please contact the administrator at \nnvhc@nvhc.com\nor call\n0796025789" );
					view.mainPanel[2].removeAll();
					  view.mainPanel[2].repaint();
					  SearchViewForVehicles searchViewForVehicles=new SearchViewForVehicles();
					  SearchControllerForVehicles searchControllerForVehicles=new SearchControllerForVehicles(searchViewForVehicles);
					  searchControllerForVehicles.ShowResultForClient(client);
					  
					  //set the button disabled
					searchViewForVehicles.updateVehicle.setEnabled(false);
					searchViewForVehicles.removeVehicle.setEnabled(false);
					view.mainPanel[2].setLayout(null);
					searchViewForVehicles.searchPanel.setBounds(0, 0, 750, 100);
					view.mainPanel[2].add(searchViewForVehicles.searchPanel);
					searchViewForVehicles.structPanel.setBounds(0, 100, 750, 600);
					view.mainPanel[2].add(searchViewForVehicles.structPanel);
					view.mainPanel[2].revalidate();
					//set the title for each dashboard objects
					  
					for(int i=0;i<5;i++) {
						view.title[i].setVisible(false);
						//if dashboard index is selected then
						view.title[0].setVisible(true);//set the title for the page
						//JButton (FInd Vehicles) 
					}
					
				}
				
				
				
			}
		});
		
	}


}
