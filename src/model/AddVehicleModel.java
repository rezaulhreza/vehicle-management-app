package model;

//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//model class for adding vehicle records
public class AddVehicleModel {
	

	//collections for add client
public void AddClient(ArrayList<String> vehicleRecord){
		
		try {
			
			//write the character on the files
			FileWriter fw=new FileWriter(new File("vehicles.txt"),true);
			BufferedWriter bw=new BufferedWriter(fw);
			
			//for each set of record move the row to the next line
			for(String avm:vehicleRecord) {
				bw.write(avm+"\n");//for each loop
			}
			bw.close();
		}
		//else catch the exception
		catch(IOException e) {
			//display the error
			JOptionPane.showMessageDialog(null,e,null, JOptionPane.WARNING_MESSAGE, null);
		}
	
	
	
		}

}
