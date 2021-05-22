package model;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//model class foe adding client
public class AddClientModel {


	public void AddClient(ArrayList<String> record){
		
		
		
		try {
			//write the character on the files
			FileWriter fw=new FileWriter(new File("customers.txt"),true);
			BufferedWriter bw=new BufferedWriter(fw);
			for(String acm:record) {
				bw.write(acm+"\n");
			}
			bw.close();
		}
		catch(IOException e) {
			//catch the exception
			JOptionPane.showMessageDialog(null, e,null, JOptionPane.WARNING_MESSAGE, null);
		}
		

	}
	

}
