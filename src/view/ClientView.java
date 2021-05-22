package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("unused")
public class ClientView {
	//client view frame
	public JFrame clientView = new JFrame();
	//array which holds button
	public JButton sidebar[]= {
			new JButton("Dashboard             "),
			new JButton("Rented Vehicles      "),
			new JButton("Manage Details"),
			new JButton("Logout           "),
			new JButton("Exit               ")
			};
	//array holds the label for title panel
	public JLabel title[]= {
			new JLabel("Dashboard"),
			new JLabel("Rented Vehicles"),
			new JLabel("Manage Details"),
			new JLabel("Logout"),
			new JLabel("Exit")
	};
	
	public JPanel mainPanel[]= {
			new JPanel(),
			new JPanel(),
			new JPanel()
			};
	//panel for dashboard
	public JPanel pHome=new JPanel();
	
	public JButton dashboard=new JButton("Find Available Vehicles");
	

	
	//client view gui
	public ClientView() {
		ImageIcon imgIcon=new ImageIcon("userProfile.png");
		JLabel imgLogo=new JLabel();
		imgLogo.setIcon(imgIcon);
		//add the logo
		mainPanel[0].add(imgLogo);
		imgLogo.setBounds(50,10,205,180);
		
	
		//set bg color for the sidebar
		mainPanel[0].setBackground((new Color(0.5f, 0.3f, 0.05f)));		
		mainPanel[0].setBounds(0,0,215,710);
		mainPanel[0].setLayout(null);
		//add sidebar items depending on the sidebar array declared above
		for(int i=0;i<sidebar.length;i++) {
			mainPanel[0].add(sidebar[i]);

			sidebar[i].setHorizontalTextPosition(SwingConstants.LEFT);
			sidebar[i].setBackground(new Color(0.5f, 0.3f, 0.1f));
			sidebar[i].setForeground(Color.white);
			sidebar[i].setBorder(BorderFactory.createLoweredBevelBorder());
			//set the foreground of the title for each page
			title[i].setForeground(Color.white);
			
			//add the title objects
			mainPanel[1].add(title[i]);
			//if set to to true it will display all the label in one line and
			title[i].setVisible(false);//it will be a mess


		}
		
		//postion of the objects within the array of sidebar
		sidebar[0].setBounds(10,240,195,48);
		sidebar[1].setBounds(10,320,195,48);
		sidebar[2].setBounds(10,400,195,48);
		sidebar[3].setBounds(10,480,195,48);
		sidebar[4].setBounds(10,560,195,48);
	
		
		//position and bg color of the 2nd object of the mainPanel
				mainPanel[1].setBackground(new Color(0.5f, 0.3f, 0.05f));
				mainPanel[1].setForeground(Color.white);
				mainPanel[1].setBounds(215,0,800,40);
				mainPanel[1].setBorder(BorderFactory.createLoweredBevelBorder());
				//main content area which holds most of the functionalities
				mainPanel[2].setBounds(235,105,770,705);		
					
				//image icon for the buttons on the dashboard area
			ImageIcon homeImage[]= {
					
						new ImageIcon("searchVehicleIcon.png")
			};
		
			pHome.add(dashboard);
			dashboard.setIcon(homeImage[0]);
			homeImage[0].setDescription("Search Vehicles");
			dashboard.setVerticalTextPosition(SwingConstants.BOTTOM);
			dashboard.setHorizontalTextPosition(SwingConstants.CENTER);
			dashboard.setBounds(50, 550, 250, 150);
			dashboard.setPreferredSize(new Dimension(150,150));
			dashboard.setBackground(new Color(0.5f, 0.3f, 0.2f));
			dashboard.setForeground(Color.white);
			clientView.setLayout(null);
			clientView.setVisible(true);
			clientView.setResizable(false);
			clientView.setTitle("Northampton Vehicle Hire Company-Client");
			
		}
		
		
	
	
	public void ClientPage() {
		// TODO Auto-generated method stub
		for(int i=0;i<mainPanel.length;i++) {
			clientView.setBounds(200,0,1020,750);
			clientView.add(mainPanel[i]);
			
			
		}
		
	}
	public void navBar(ActionListener a) {
		for(int i=0;i<sidebar.length;i++) {
			sidebar[i].addActionListener(a);
		}
		dashboard.addActionListener(a);
		
	}

}
