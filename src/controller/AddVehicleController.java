package controller;

import model.*;
import view.*;


import java.awt.event.*;
import java.io.*;
import java.util.*;


import javax.swing.*;




//controller class for vehicle adding
public class AddVehicleController {
	/**
	 * 
	 */

	AddVehicleView view;
	AddVehicleModel model;
	
	//constructor
	public AddVehicleController(AddVehicleView view, AddVehicleModel model) {
		
		this.view= view;//refers to the add vehicle view
		this.model = model;//refers to the add vehicle controller
	}

	//method to save record into the file
	public void addVehicle() {
		String strNumValidation = "[a-zA-Z]+";
		
		//https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
		String strInputValidation =("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ._@#*-`¬¦|><~=_/?+,()&^%$£€''");
		writeClient();
		//when add client button is clicked this action is invoked
		view.addClientBtnListener(new ActionListener() {
			//ovverride method to add the records
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				ArrayList<String> vehicleList=new ArrayList<String>();
			
				
				if(
						view.textField[0].getText().matches(strNumValidation)
						||
						//if the text fields are set to empty
						view.textField[0].getText().startsWith("-")
						||
						view.textField[0].getText().equals("")
						||
						view.textField[0].getText().endsWith("-")
						||
						view.textField[0].getText().contains("-")
						||
						
						
						view.textField[1].getText().startsWith("-")
						||
						view.textField[1].getText().equals("")
						||
						view.textField[1].getText().endsWith("-")
						||
						view.textField[1].getText().contains("-")
						
						
						
						||
						
						
						view.textField[2].getText().startsWith("-")
						||
						view.textField[2].getText().endsWith("-")
						||
						view.textField[2].getText().contains("-")
						||
						view.textField[2].getText().equals("")
						
						
						
						||
						view.textField[3].getText().startsWith("-")
						||
						view.textField[3].getText().endsWith("-")
						||
						view.textField[3].getText().contains("-")
						||
						view.textField[3].getText().equals("")
						||
						
						view.textField[4].getText().matches(strNumValidation)
						||
						view.textField[4].getText().startsWith("-")
						||
						view.textField[4].getText().equals("")
						||
						view.textField[4].getText().endsWith("-")
						||
						view.textField[4].getText().contains("-")
						||
						
						
						view.textField[5].getText().startsWith("-")
						||
						view.textField[5].getText().endsWith("-")
						||
						view.textField[5].getText().contains("-")
						||
						
						view.textField[5].getText().matches(strNumValidation)
						||
						
						
						
						
						
						view.textField[6].getText().matches(strInputValidation)
						||
						view.textField[6].getText().startsWith("-")
						||
						view.textField[6].getText().endsWith("-")
						||
						view.textField[6].getText().contains("-")
						||
						
						
						
						view.textField[7].getText().startsWith("-")
						||
						view.textField[7].getText().endsWith("-")
						||
						view.textField[7].getText().contains("-")
						||
						
						
						view.textField[8].getText().startsWith("-")
						||
						view.textField[8].getText().endsWith("-")
						||
						view.textField[8].getText().contains("-")
					
						
						

						)
					//display a JOptionPane dialog
					JOptionPane.showMessageDialog(null,"Record could not be added"
							+ "\nYou must check/fill all the fields"
							);
				
				else{
					vehicleList.add(
							//else add the value 
							view.textField[0].getText()
									+
									//and add a '-' after every records
									"-"
									+
									//then convert the text to UpperCase
							view.textField[1].getText().toUpperCase()
									+
									"-"
									+
							view.textField[2].getText().toUpperCase()
									+
									"-"
									+
							view.textField[3].getText().toUpperCase()
									+
									"-"
									+
							view.textField[4].getText().toUpperCase()
									+
									"-"
									+
							view.textField[5].getText().toUpperCase()
									+
									"-"
									+
									
									
							
							
							view.textField[6].getText().toUpperCase()
									+
									"-"
									+
									
							view.textField[7].getText().toUpperCase()
									+
									"-"
									+
							view.textField[8].getText().toUpperCase()
									+
									"-"
									+
									
									
							
							//get selected item from the records which used Combo box
							view.cBox.getSelectedItem().toString().toUpperCase()
									+
									"-"
									+
							view.clientComboBox.getSelectedItem().toString()
							);
					//display a success message
					JOptionPane.showMessageDialog(null,"Vehicle record added successfully!");
					//call the setTextFieldValue method from view and set the text field value empty
					view.setTextFieldValue();
					//call the model class object and assign the add client method
					model.AddClient(vehicleList);
				
			}
			}
		});
		
	}
	
	//method to add the record on the file connected to client
	public void writeClient() {
		
		try {
			@SuppressWarnings("resource")
			
			Scanner avScanner = new Scanner(new File("customers.txt"));
			String fType;
			String [] dSplit;
			while (avScanner.hasNextLine()) {
					fType= avScanner.nextLine();
					dSplit=fType.split("-");
					String clientComboBox = dSplit[1];
					view.clientComboBox.addItem(clientComboBox);
				
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(null, "File missing!",null, JOptionPane.WARNING_MESSAGE, null);
		}
		
	}
	

}
