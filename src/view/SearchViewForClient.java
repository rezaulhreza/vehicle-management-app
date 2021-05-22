package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//class to display results of client
public class SearchViewForClient {
	//main panel
	public JPanel structPanel=new JPanel();
	//jtable for displaying the data in a table
	public JTable table = new JTable();
	public JButton removeClient = new JButton("Delete");
	public JButton updateClient = new JButton("Update");
	//column name array
	public Object[] column = {
			"Id", 
			"Username", "Corp. Name",
			"Phone","Password",
			"Email","Address","ZIP"
};
	//table model
	//java default table model class
	public DefaultTableModel DtModel = new DefaultTableModel();
	
	
	//constructor
	public SearchViewForClient() {
		//set the column name
		DtModel.setColumnIdentifiers(column);
		//set the table model
		table.setModel(DtModel);
		//row height
		table.setRowHeight(25);
		//set grid color 
		table.setGridColor(Color.GREEN);
	
		//set layout for the panel of the view
		structPanel.setLayout(new GridLayout(2,1));
		
		//scroll bar for the table
		JScrollPane scrollPane = new JScrollPane(table);
		structPanel.add(scrollPane);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		structPanel.add(mainPanel);
		mainPanel.add(removeClient);
		mainPanel.add(updateClient);
		removeClient.setBounds(70, 150, 120, 40);
		updateClient.setBounds(70, 90, 120, 40);
				
	}
	
	//action listener for the buttons
	public void ShowResultForClient(ActionListener a) {
		removeClient.addActionListener(a);
		updateClient.addActionListener(a);
	}
	
}