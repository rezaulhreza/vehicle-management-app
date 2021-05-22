package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;

import view.*;

public class SearchControllerForClient {

	/**
	 * 
	 */
	
	SearchViewForClient view;

	public SearchControllerForClient(SearchViewForClient view) {
		// TODO Auto-generated constructor stub
		this.view=view;
	}

	@SuppressWarnings("resource")
	public void addRecord() {
		// TODO Auto-generated method stub
		Object fields[]=new Object[8];
		
		try {
			Scanner clientScanner = new Scanner(new File("customers.txt"));
			String fType;
			String [] dSplit;
			while (clientScanner.hasNextLine()) {
				fType = clientScanner.nextLine();
				dSplit =fType.split("-");
				
				fields[0] = dSplit[0];
				fields[1] = dSplit[1];
				fields[2] = dSplit[2];
				fields[3] = dSplit[3];
				fields[4] = dSplit[4];
				fields[5] = dSplit[5];
				fields[6] = dSplit[6];
				fields[7] = dSplit[7];
				
				view.DtModel.addRow(fields);
				
			}
		} 
		catch (FileNotFoundException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "File missing",null,JOptionPane.WARNING_MESSAGE,null);
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Error!\n'ArrayIndexOutOfBoundsException' occurred"
					+ 
					"\nError Details:"
					+
					"\nOne or many data in the row is missing a '-'\nOr there in extra '-'"
					+
					"\nin\n 'customers.txt' file\n"
					+
					"\nCheck If there is something like\n'0-2-3-4-5-6-7-8-9-10'"
					+
					"\nInsert only one '-' after each record where  missing"
					+
					"\ne.g\n       '0-1-2-3-4-5-6-7-8-9-10'"
					,null, JOptionPane.WARNING_MESSAGE, null);
		}
	}

	public void addRowClient(String client) {
		Object fields[]=new Object[8];
		try {
			@SuppressWarnings("resource")
			Scanner scanner =new Scanner(new File("customers.txt"));
			String fType;
			String [] dSplit;
			while(scanner.hasNextLine()) {
				fType =scanner.nextLine();
				dSplit=fType.split("-");
				if(dSplit[1].equals(client)) {
				fields[0] = dSplit[0];
			     fields[1] = dSplit[1];
			     fields[2] = dSplit[2];
			     fields[3] = dSplit[3];
			     fields[4] = dSplit[4];
			     fields[5] = dSplit[5];
				fields[6] = dSplit[6];
				fields[7] = dSplit[7];
			     view.DtModel.addRow(fields);
				}
				
			}
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File Missing\n'customers.txt'",null,JOptionPane.WARNING_MESSAGE,null);
		}catch(ArrayIndexOutOfBoundsException e) {
			
			JOptionPane.showMessageDialog(null, "Error!\n'ArrayIndexOutOfBoundsException' occurred"
					+ 
					"\nError Details:"
					+
					"\nOne or many data in the row is missing a '-'\nOr there in extra '-'"
					+
					"\nin\n 'customers.txt' file\n"
					+
					"\nCheck If there is something like\n'0-2-3-4-5-6-7-8-9-10'"
					+
					"\nInsert only one '-' after each record where  missing"
					+
					"\ne.g\n       '0-1-2-3-4-5-6-7-8-9-10'"
					,null, JOptionPane.WARNING_MESSAGE, null);
		}

	}

	public void ShowResultForClient() {
		
		view.ShowResultForClient(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==view.updateClient) {
					
					int tab = view.table.getSelectedRow();
		            
		            if(tab >= 0) 
		            {
		            	ArrayList<String> array=storage();
		        		String[] subArray;
		        		for(int i=0;i<array.size();i++) {
		        			subArray=array.get(i).split("-");
		        			if(subArray[0].equals(view.DtModel.getValueAt(tab, 0))) {
		        				array.set(i, view.DtModel.getValueAt(tab,0).toString()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,1).toString()//username
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,2).toString().toUpperCase()//convert the string into Uppercase
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,3).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,4).toString()//password
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,5).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,6).toString().toUpperCase()
		        						+
		        						"-"
		        						+
		        						view.DtModel.getValueAt(tab,7).toString().toUpperCase()
		        						
		        					
		        						);
		        				create(array);
		        				JOptionPane.showMessageDialog(null,"Client record Updated");
		        			}
		        			
		        		}
		        				
		        	}
					
					
				}
				
				if(e.getSource()==view.removeClient) {
					int tab = view.table.getSelectedRow();
					
				
		            
					 if(tab >= 0) 
			            {
			            	ArrayList<String> array=storage();
			        		String [] userData;;
			        		
			        		for(int i=0;i<array.size();i++) {
			        			userData=array.get(i).split("-");
			        			
			        			if(userData[1].equals(view.DtModel.getValueAt(tab, 1).toString())) {
			        				if((userData[1].equals("Available"))) {
			        					//warning message if this account is about to be deleted
			        					JOptionPane.showMessageDialog(null, "Warning\nThis account holds all the available vehicles.\nIf this account is deleted\nYou need to create another record for this acccount\nfrom 'Add Client'\nAnd enter the username\n'Available'"
			        							
			        							,null, JOptionPane.WARNING_MESSAGE, null);
			        					
			        				}
			        			}
			        			
			        			
			        			
			        			if(userData[0].equals(view.DtModel.getValueAt(tab,0).toString())||userData[1]!="Available") {
			        				array.remove(i);
			        				create(array);
			        				view.DtModel.removeRow(tab);
			        				JOptionPane.showMessageDialog(null,"Client record Deleted");
			        			}
			        			
			        			
			        			
			        				
			        			}
			            	
			            }        
					
				}
				
			}
			
		});
	}

	public static ArrayList<String> storage(){
		ArrayList<String> rows =new ArrayList<String>();
		String s;
		try {
			@SuppressWarnings("resource")
			Scanner scanner=new Scanner(new File("customers.txt"));
			while(scanner.hasNext()) {
				s=scanner.nextLine();
				rows.add(s);
			}
			return rows;
		}
		catch(IOException e) {
			
		}
		return null;
	}

	public static void create(ArrayList<String> firstString) {
		try {
			FileWriter fw=new FileWriter(new File("customers.txt"));
			BufferedWriter bw=new BufferedWriter(fw);
			for(String s:firstString) {
				bw.write(s+"\n");
			}
			bw.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "File update unsuccessful",null, JOptionPane.WARNING_MESSAGE, null);
		}
	}


	}

