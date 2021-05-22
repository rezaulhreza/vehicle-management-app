package view;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
public class SearchViewForVehicles {
	

	public JPanel searchPanel=new JPanel();
	public JPanel structPanel=new JPanel();
	public JTable table =new JTable();
	
	public String[] vehicleType= {"CAR","MINIBUS","LORRY"};
	
	
	public JComboBox<String> cBox  = new JComboBox<String>();
	
	
	private JLabel findLabelVType = new JLabel("Find by Vehicle Type");
	public JButton searchButtonVType  = new JButton("Search");
	
	public JButton removeVehicle = new JButton("Delete");
	public JButton updateVehicle = new JButton("Update");
	public JPanel findPanel = new JPanel();
	public JTextField searchField =new JTextField(4);
	private JLabel findLabelID = new JLabel("find by ID");
	public JButton searchButtonID  = new JButton("Search");
	
	
	
	private int number = 0;
	
	

    public DefaultTableModel DtModel = new DefaultTableModel();
    public boolean isCellEditable(int rowIndex, int mColIndex) {
    	JOptionPane.showMessageDialog(null, "Id is not editable");
        return false;
      }
    public Object[] column = {
    		"Id",
    		"Model",
    		"Make",
    		"Reg. No",
    		"Daily Hire Rate",
    		"Max Speed"
    		,"Seat"
    		,"Load"
    		,"Doors",
    		"Vehicle Type"
    		,"Hired By"
    		
    };
    public SearchViewForVehicles() {
		// search area 
    	searchPanel.setLayout(null);
    	searchPanel.add(findLabelID);
    	searchPanel.add(searchField);
    	searchPanel.add(searchButtonID);/*{searchButtonID add search button for id}*/
    	findLabelID.setBounds(100, 0, 200, 30);
    	searchField.setBounds(320, 0, 200, 30);
    	searchButtonID.setBounds(540, 0, 100, 30);
    	
    	searchPanel.add(findLabelVType);
    	findLabelVType.setBounds(100,50,200,30);
    	searchPanel.add(cBox);
		cBox.setBounds(320,50,200,30);
		for(int i=0;i<vehicleType.length;i++)
			cBox.addItem(vehicleType[number++]);
		searchPanel.add(searchButtonVType);
		searchButtonVType.setBounds(539, 50, 102, 32);
		
				
		
    	
		
		//empty table structure for vehicles details
		DtModel.setColumnIdentifiers(column);
		table.setModel(DtModel);
        table.setRowHeight(25);
      
       
     ;
        
        structPanel.setLayout(new GridLayout(2,5));
        JScrollPane scrollPane = new JScrollPane(table);
        structPanel.add(scrollPane);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);
        structPanel.add(mainPanel);
        mainPanel.add(removeVehicle);
        removeVehicle.setBounds(70, 150, 120, 40);
        mainPanel.add(updateVehicle);
        updateVehicle.setBounds(70, 90, 120, 40);
    }
	
    public void ShowResultForVehicle(ActionListener a) {
		removeVehicle.addActionListener(a);
		updateVehicle.addActionListener(a);
		searchButtonVType.addActionListener(a);
		searchButtonID.addActionListener(a);
}
    

}
