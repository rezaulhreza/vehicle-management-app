package model;

import java.io.*;
import java.util.*;

//model class for login
public class LoginModel {

	
	//check admin login
	public boolean checkStaff(String firstString,String secondString) {
		//if username is admin and password is admin then log in to the system
			if(firstString.equals("admin") & secondString.equals("admin"))			
				return true;
			else	
				//deny access
			return false;
	}
	
	//method to check client login
	public boolean checkClient(String firstString,String secondString) throws FileNotFoundException {
		//initially return false
		boolean output = false;
			
			@SuppressWarnings("resource")
			//read file
			Scanner loginScanner = new Scanner(new File("customers.txt"));
			//fType is the record name on each index
				String fType;
				//dSplit is the array which splits the data with -
				String [] dSplit;
				while(loginScanner.hasNextLine()) {
					fType =loginScanner.nextLine();
					//file record and then - 
					//only then read the data
					dSplit=fType.split("-");
					//if the username matches the first index and 4th index
					if(firstString.equals(dSplit[1]) & secondString.equals(dSplit[4]))
						//return the user to the client page
						return output=true;
			} 
			return output;
			
				
			}
}



