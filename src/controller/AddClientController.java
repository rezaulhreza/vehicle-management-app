package controller;

import java.awt.event.*;

import java.util.*;
import javax.swing.*;
import model.*;
import view.*;
public class AddClientController{

	private AddClientView view;
	private AddClientModel model;

	public AddClientController(AddClientView view, AddClientModel model) {
		// TODO Auto-generated constructor stub
		this.model=model;
		this.view=view;
	}

	public void AddClient() {
		// TODO Auto-generated method stub
		
		String str = "[a-zA-Z]+";
		String strInputValidation = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ._@#*-`¬¦|><~=_/?+,()&^%$£€''"); 
		view.AddClientBtnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae2) {
				ArrayList<String> addClientList=new ArrayList<String>();
				// TODO Auto-generated method stub
				if(
						//input validation
						
						view.textField[0].getText().matches(str)
						||
						view.textField[0].getText().startsWith(strInputValidation)
						||
					view.textField[0].getText().endsWith(strInputValidation)
									||
					view.textField[0].getText().equals("") 
									||
									
									
					view.textField[1].getText().equals("") 
									||			
					view.textField[1].getText().startsWith("-")
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
					

					view.textField[3].getText().matches(str)
									||				
					view.textField[3].getText().startsWith("-")
									||		
					view.textField[3].getText().endsWith("-")
									||
					view.textField[3].getText().contains("-")
									||
					view.textField[3].getText().equals("")
									||
									
									
					view.textField[4].getText().startsWith("-")
									||
					view.textField[4].getText().endsWith("-")
									||
					view.textField[4].getText().contains("-")
									||
					view.textField[4].getText().equals("")
									||
									
					view.textField[5].getText().startsWith("-")
									||
					view.textField[5].getText().endsWith("-")
									||
					view.textField[5].getText().contains("-")
									||
					
					view.textField[5].getText().equals("")
									||
									
					
				    view.textField[6].getText().startsWith("-")
									||
					view.textField[6].getText().endsWith("-")
									||
					view.textField[6].getText().contains("-")
									||
					view.textField[6].getText().equals("")
									||
									
									
					view.textField[7].getText().startsWith("-")
									||
					view.textField[7].getText().endsWith("-")
									||
					view.textField[7].getText().contains("-")
					||
					view.textField[7].getText().equals("")
					) 
					JOptionPane.showMessageDialog(null,"Record could not be added"
							+ "\nYou must check/fill all the fields\n Do not enter any invalid characters."
							);
				else {			
				addClientList.add(
				view.textField[0].getText()
								+
								"-"
								+
				  view.textField[1].getText()
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
				  view.textField[4].getText()
				  +
				  "-"
				  + view.textField[5].getText().toUpperCase()
				  +
				  "-"
				  + view.textField[6].getText().toUpperCase()
				  +
				  "-"
				  + view.textField[7].getText().toUpperCase()
				  
				 
				  
				  );
				JOptionPane.showMessageDialog(null,"Client record added successfully!");
				model.AddClient(addClientList);
				view.setTextFieldValue();
				}
				
			}
		});
		
	}
	
	
}
