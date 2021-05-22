
package controller;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


import javax.swing.*;
import java.util.*;

//vehicle details controller class
public class SearchControllerForVehicles {

	SearchViewForVehicles view;

	//clonstructor
	public SearchControllerForVehicles(SearchViewForVehicles view) {
		// TODO Auto-generated constructor stub
		this.view=view;//refer to the view object
	}

	//method to add the record
	public void addRecord() {
		// TODO Auto-generated method stub
		//11 objects for 11 record
		Object[] fields = new Object[11];
		try {
			@SuppressWarnings("resource")
			
			Scanner scanner = new Scanner(new File("vehicles.txt"));
			String fType;
			String[] dSplit;
			while (scanner.hasNextLine()) {
				fType = scanner.nextLine();
				dSplit = fType.split("-");
				fields[0] = dSplit[0];
			     fields[1] = dSplit[1];
			     fields[2] = dSplit[2];
			     fields[3] = dSplit[3];
			     fields[4] = dSplit[4];
			     fields[5] = dSplit[5];
			     fields[6] =dSplit[6];
			     fields[7] =dSplit[7];
			     fields[8] =dSplit[8];
			     fields[9] =dSplit[9];
			     fields[10] =dSplit[10];
			     //add the fields using addRow method of default table model class
			     view.DtModel.addRow(fields);
			     
			     
				
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "File Missing\n'vehicles.txt'",null,JOptionPane.WARNING_MESSAGE,null);
			}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Error!\n'ArrayIndexOutOfBoundsException' occurred"
					+ 
					"\nError Details:"
					+
					"\nOne or many data in the row is missing a '-'\nOr there in extra '-'"
					+
					"\nin\n 'vehicles.txt' file\n"
					+
					"\nCheck If there is something like\n'0-2-3-4-5-6-7-8-9-10'"
					+
					"\nInsert only one '-' after each record where  missing"
					+
					"\ne.g\n       '0-1-2-3-4-5-6-7-8-9-10'"
					,null, JOptionPane.WARNING_MESSAGE, null);
		}
		
	}
	//add the record related to client
	public void addClientRow(String client) {
		Object[] fields = new Object[11];
		try {
			@SuppressWarnings("resource")
			Scanner input =new Scanner(new File("vehicles.txt"));
			String fType;
			String [] dSplit;
			while(input.hasNextLine()) {
				fType =input.nextLine();
				dSplit=fType.split("-");
				if(dSplit[10].equals(client)) {
				fields[0] = dSplit[0];
			     fields[1] = dSplit[1];
			     fields[2] = dSplit[2];
			     fields[3] = dSplit[3];
			     fields[4] = dSplit[4];
			     fields[5] = dSplit[5];
			     fields[6] =dSplit[6];
			     fields[7] =dSplit[7];
			     fields[8] =dSplit[8];
			     fields[9] =dSplit[9];
			     fields[10] =dSplit[10];
			     view.DtModel.addRow(fields);
				}
				
			}
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File Missing",null, JOptionPane.WARNING_MESSAGE, null);	
			}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Error!\n'ArrayIndexOutOfBoundsException' occurred"
					+ 
					"\nError Details:"
					+
					"\nOne or many data in the row is missing a '-'\nOr there in extra '-'"
					+
					"\nin\n 'vehicles.txt' file\n"
					+
					"\nCheck If there is something like\n'0-2-3-4-5-6-7-8-9-10'"
					+
					"\nInsert only one '-' after each record where  missing"
					+
					"\ne.g\n       '0-1-2-3-4-5-6-7-8-9-10'"
					,null, JOptionPane.WARNING_MESSAGE, null);
		}
	}
	

	//method to display vehicle details
	public void ShowResultForVehicle(){
		// TODO Auto-generated method stub
		view.ShowResultForVehicle(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//if update vehicle button is pressed
				if(e.getSource()==view.updateVehicle) {
					//return the indexes of row
					int tab = view.table.getSelectedRow();
		            
		            if(tab >= 0) 
		            {
		            	//to store the data and then display
		            	ArrayList<String> array=storage();
		        		String[] subArray;
		        		for(int i=0;i<array.size();i++) {
		        			//get the array index and split it with - 
		        			subArray=array.get(i).split("-");
		        			
		        			
		        				
		        			
		        			if(subArray[0].equals(view.DtModel.getValueAt(tab, 0))) {
		        				array.set(
		        						i,
		        						//return attribute using default table model's getvalueat method
		        						view.DtModel.getValueAt(tab,0).toString()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,1).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,2).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,3).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,4).toString().toUpperCase()
		        						+
		        						"-"
		        						+view.DtModel.getValueAt(tab,5).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,6).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab, 7).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab, 8).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab, 9).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab, 10).toString()
		        						
		        						
		        						);
		        				//call create method
		        				create(array);//create the array
		        				JOptionPane.showMessageDialog(null,"Vehicle Updated");
		        				
		        			}
		        			
		        			
		        		}
		        		
		        				
		        	}
		          
					
					
				}
				
				//if remove vehicle is selected
				if(e.getSource()==view.removeVehicle) {
					//get the row from jtable
					int tab = view.table.getSelectedRow();
					
		            
					 if(tab >= 0) 
			            {
			            	ArrayList<String> array=storage();
			        		String [] vehicleInfo;;
			        		
			        		for(int i=0;i<array.size();i++) {
			        			vehicleInfo=array.get(i).split("-");
			        			//if a row is selected and it matches with the index of the file
			        			//index 0*
			        			if(vehicleInfo[0].equals(view.DtModel.getValueAt(tab,0).toString())) {
			        				array.remove(i);
			        				create(array);
			        				//then remove row from the table model
			        				view.DtModel.removeRow(tab);
			        				JOptionPane.showMessageDialog(null,"Vehicle Deleted");
			        			}
			        			
			        			
			        				
			        			}
			            	
			            }        
					
				}
				//if vehicle type is choosen on search area
				if(e.getSource()==view.searchButtonVType) {
					
					Object[] fields = new Object[11];
					try {
						@SuppressWarnings("resource")
						//read the file
						Scanner scanner =new Scanner(new File("vehicles.txt"));
						String fType;
						String [] dSplit;
						while(scanner.hasNextLine()) {
							fType =scanner.nextLine();
							dSplit=fType.split("-");
							//if vehicle type matches with array from file and comboBpox
							
							if(dSplit[9].equals(view.cBox.getSelectedItem().toString())) {
							fields[0] = dSplit[0];
						     fields[1] = dSplit[1];
						     fields[2] = dSplit[2];
						     fields[3] = dSplit[3];
						     fields[4] = dSplit[4];
						     fields[5] = dSplit[5];
						     fields[6] =dSplit[6];
						     fields[7] =dSplit[7];
						     fields[8] =dSplit[8];
						     fields[9] =dSplit[9];
						     fields[10] =dSplit[10];
						     
						     //add the record 
						     view.DtModel.addRow(fields);
						     
							}
							
						
							
						}
					}
					catch(FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "File Missing",null, JOptionPane.WARNING_MESSAGE, null);
					}

					
				}
				
				//if search by id is selected
				else if(e.getSource()==view.searchButtonID) {
					Object[] fields = new Object[11];
					try {
						@SuppressWarnings("resource")
						Scanner scanner =new Scanner(new File("vehicles.txt"));
						String fType;
						String [] dSplit;
						while(scanner.hasNextLine()) {
							fType =scanner.nextLine();
							dSplit=fType.split("-");
							//if the index 0 (id) is selected and it matches
							if(dSplit[0].equals(view.searchField.getText())) {
							fields[0] = dSplit[0];
						     fields[1] = dSplit[1];
						     fields[2] = dSplit[2];
						     fields[3] = dSplit[3];
						     fields[4] = dSplit[4];
						     fields[5] = dSplit[5];
						     fields[6] =dSplit[6];
						     fields[7] =dSplit[7];
						     fields[8] =dSplit[8];
						     fields[9] =dSplit[9];
						     fields[10] =dSplit[10];
						     
						     //call the method
						     view.DtModel.addRow(fields);
						     
							}
						
							
						}
					}
					catch(FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "File Missing",null, JOptionPane.WARNING_MESSAGE, null);
					}

					
				}
				
			}

			

			
		});
	}

	//display result for client
	public void ShowResultForClient(String client) {
		
		view.ShowResultForVehicle(new ActionListener() {

			@Override
			//invokes the below action
			public void actionPerformed(ActionEvent e) {
				//if search by vehicle type button is selected
				if(e.getSource()==view.searchButtonVType) {
					//class object
					Object[] fields = new Object[11];
					try {
						@SuppressWarnings("resource")
						Scanner scanner =new Scanner(new File("vehicles.txt"));
						String fType;
						String [] dSplit;
						while(scanner.hasNextLine()) {
							fType =scanner.nextLine();
							dSplit=fType.split("-");
							//if vehicles type is selected and matches with the file against the combo box
							if(dSplit[9].equals(view.cBox.getSelectedItem().toString())) {
								//and if index 10 which is the hired by column has Available in it
							if((dSplit[10].equals("Available"))) {
								//then display the records which has available on index 10
							fields[0] = dSplit[0];
						     fields[1] = dSplit[1];
						     fields[2] = dSplit[2];
						     fields[3] = dSplit[3];
						     fields[4] = dSplit[4];
						     fields[5] = dSplit[5];
						     fields[6] =dSplit[6];
						     fields[7] =dSplit[7];
						     fields[8] =dSplit[8];
						     fields[9] =dSplit[9];
						     fields[10] =dSplit[10];
						     //add the row in the GUI using add row method of default table model class
						     view.DtModel.addRow(fields);
							}
							
						     
							}
						
							
						}
					}
					catch(FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "File Missing",null, JOptionPane.WARNING_MESSAGE, null);
					}

					
				}
				
				else if(e.getSource()==view.searchButtonID) {
					Object[] fields = new Object[11];
					try {
						@SuppressWarnings("resource")
						Scanner scanner =new Scanner(new File("vehicles.txt"));
						String fType;
						String [] dSplit;
						while(scanner.hasNextLine()) {
							fType =scanner.nextLine();
							dSplit=fType.split("-");
							if(dSplit[0].equals(view.searchField.getText())) {
							if((dSplit[10].equals("Available"))) {
							fields[0] = dSplit[0];
						     fields[1] = dSplit[1];
						     fields[2] = dSplit[2];
						     fields[3] = dSplit[3];
						     fields[4] = dSplit[4];
						     fields[5] = dSplit[5];
						     fields[6] =dSplit[6];
						     fields[7] =dSplit[7];
						     fields[8] =dSplit[8];
						     fields[9] =dSplit[9];
						     fields[10] =dSplit[10];
						     view.DtModel.addRow(fields);
							}
						     
							}
						
							
						}
					}
					catch(FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "File update unsuccessful",null, JOptionPane.WARNING_MESSAGE, null);
					}

					
				}
				
			}
			
		});
	}

	//method storage to store the data on the system
	public static ArrayList<String> storage(){
		ArrayList<String> rows =new ArrayList<String>();
		String storage;
		try {
			@SuppressWarnings("resource")
			Scanner scanner=new Scanner(new File("vehicles.txt"));
			while(scanner.hasNext()) {
				storage=scanner.nextLine();
				rows.add(storage);
			}
			return rows;
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "File update unsuccessful",null, JOptionPane.WARNING_MESSAGE, null);
			
		}
		return null;
	}
	
	public static void create(ArrayList<String> firstString) {
		try {
			FileWriter fw=new FileWriter(new File("vehicles.txt"));
			BufferedWriter bw=new BufferedWriter(fw);
			for(String str:firstString) {
				bw.write(str+"\n");
			}
			bw.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "File update unsuccessful",null, JOptionPane.WARNING_MESSAGE, null);

		}
	}	
	

	


		
	}


