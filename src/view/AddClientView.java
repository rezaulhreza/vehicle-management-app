package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

//class for adding client
public class AddClientView {
	
	//label for add client label
	private JLabel addClientLabel[] = {
			new JLabel("Id"),
			new JLabel("Username"),
			new JLabel("Corporation name"),
			new JLabel("Phone"),
			new JLabel("Password"),
			new JLabel("Email"),
			new JLabel("Address"),
			new JLabel("ZIP")
	};
	
	//text field for the form
	public JTextField textField[] = {
			new JTextField(20),
			new JTextField(20),
			new JTextField(20),
			new JTextField(20),
			new JTextField(20),
			new JTextField(20),
			new JTextField(20),
			new JTextField(20)
	};
	
	
	
	//layout for the form
	public JPanel structPanel  = new JPanel(new GridLayout(11,0,0,10));
	
	//button add client
	public JButton addClientBtn = new JButton("Add Client");
	
	//decalre variables
	private String id, username,password, fname, surname, aLine1, aline2,pCode,county;
	
	//constructor
	public AddClientView(String id, String username, String fname, String surname, String aLine1, String aline2, String pCode, String county, String password) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.username=username;
		this.fname=fname;
		this.password=password;
		this.surname=surname;
		this.aLine1=aLine1;
		this.aline2=aline2;
		this.pCode=pCode;
		this.county=county;
		
		//add client label and text field of the form in the panel
		for (int i = 0; i < addClientLabel.length; i++) {
			structPanel.add(addClientLabel[i]);
			structPanel.add(textField[i]);
		}
		
		structPanel.add(addClientBtn);
	}
	//set the text field value after inserting the record to empty
	public void setTextFieldValue() {
		for(int i=0;i<textField.length;i++) {
			textField[i].setText("");
		}
	
	}
	
	
	public String getId() {
	return id;
	}

	public String getUsername() {
		return username;
	}
	
	public String getFname() {
		return fname;
	}

	
	public String getPassword() {
		return password;
	}
	public String getSurname() {
		return surname;
	}
	
	public String getaLine1() {
		return aLine1;
	}
	
	public String getAline2() {
		return aline2;
	}
	
	public String getpCode() {
		return pCode;
	}
	
	public String getCounty() {
		return county;
	}
	public void AddClientBtnListener(ActionListener e) {
		addClientBtn.addActionListener(e);
	}

}
