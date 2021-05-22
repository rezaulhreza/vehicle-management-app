package view;


import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AddVehicleView {

	//decalring new j panel
	public JPanel structPanel=new JPanel(); 
	//label for the forms
	private JLabel columnLabel[]= {
			//table column name
			
			new JLabel("Vehicle ID *"),
			new JLabel("Model *"),
			new JLabel("Make *"),
			new JLabel("Reg No *"),
			new JLabel("Daily hire rate (£) *"),
			new JLabel("Max Speed (MPH)"),
			new JLabel("Seating Capacity (Minibus only)"),
			new JLabel("Loading Capacity (Lorry only)"),
			new JLabel("Doors (i.e 5)")
			
	};
	//textfields for above fields
	public JTextField textField[]= {
			new JTextField(10),//0
			new JTextField(20),//1
			new JTextField(20),//2
			new JTextField(20),//3
			new JTextField(20),//4
			new JTextField(20),//5
			new JTextField(20),//8
			new JTextField(20),//9
			new JTextField(20)//10
	};
//	private JLabel label2 = new JLabel();
	//label for combo box
	private JLabel vehicle =new  JLabel("Vehicle Type");
	
	//array to display in the combo box
	public String[] vehicleType = {"CAR","MINIBUS","LORRY"};
	//combo box for vehicle type
	public JComboBox<String> cBox = new JComboBox<String>();
	//label and combo box for client name selection
	public JLabel clientNameLabel = new JLabel("Allot a client");
	
	public JComboBox<String> clientComboBox = new JComboBox<String>();
	
	private int number = 0;
	
	private JButton addVehicleBtn = new JButton("Issue Vehicle");
	
	//declaring variables
	private String id, model,make, regNo, dhRate,  maxSpeed,hired, hiredBy,seat,load,door;
	//constructor
	public AddVehicleView(String id,
			String model,
			String make,
			String regNo,
			String maxSpeed,
			String hired,
			String hiredBy,
			String seat,
			String load,
			String door,
			String dhRate
			) {

		this.id=id;
		this.model=model;
		this.make=make;
		this.regNo=regNo;
		this.dhRate=dhRate;
		this.maxSpeed="";
		this.seat="";
		this.load="";
		this.door="";
		this.hired=hired;
		this.hiredBy=hiredBy;
		
		//GRID LAYOUT FOR ADDING VEHICLES
		GridLayout gridLayout  = new GridLayout(15,0,0,10);
		structPanel.setLayout(gridLayout);
		
		//add the label for the form		
					for (int i = 0; i < columnLabel.length; i++) {
						//add the indexes of label and text fields
						structPanel.add(columnLabel[i]);
						structPanel.add(textField[i]);
		}
			
			structPanel.add(vehicle);
			structPanel.add(cBox);
				//for the length of vehicle type array add the combo box item and increment
					for(int i=0;i<vehicleType.length;i++) {
					cBox.addItem(vehicleType[number++]);
			}
			
			structPanel.add(clientNameLabel);
			structPanel.add(clientComboBox);

			structPanel.add(addVehicleBtn);
		}
	
	
	public void addClientBtnListener(ActionListener a) {
		addVehicleBtn.addActionListener(a);
	}
	
	public void setTextFieldValue() {
		for (int i = 0; i < textField.length; i++) {
			textField[i].setText("");
		}
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getMake() {
		return make;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setDhRate(String dhRate) {
		this.dhRate = dhRate;
	}
	public String getDhRate() {
		return dhRate;
	}
	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getMaxSpeed() {
		return maxSpeed;
	}
	public void setHired(String hired) {
		this.hired = hired;
	}
	public String getHired() {
		return hired;
	}
	public void setHiredBy(String hiredBy) {
		this.hiredBy = hiredBy;
	}
	public String getHiredBy() {
		return hiredBy;
	}


	public String getDoor() {
		return door;
	}


	public void setDoor(String door) {
		this.door = door;
	}


	public String getSeat() {
		return seat;
	}


	public void setSeat(String seat) {
		this.seat = seat;
	}


	public String getLoad() {
		return load;
	}


	public void setLoad(String load) {
		this.load = load;
	}
		
	
	
	
}







