import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.sql.*;

public class CarDB {
	
	static Connection con;
	static Statement stmt;
	
	public static void HomeView(){
		
		JFrame frame = new JFrame("Home");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
			
		JLabel label = new JLabel("Welcome to Used Car DataBase");
			
		JButton AddCar = new JButton();
		JButton ViewDataBase = new JButton();
		JButton AddEmployee = new JButton();
		JButton AddSale = new JButton();
		
		AddCar.setText("Add Car");
		AddEmployee.setText("Add Employee");
		AddSale.setText("Add Sale");
		ViewDataBase.setText("View Data Base");
		
		panel.add(label);
		panel.add(AddCar);
		panel.add(AddEmployee);
		panel.add(AddSale);
		panel.add(ViewDataBase);

		frame.add(panel);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		AddCar.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
			  addCar();  
	            
			}  
	  });
	}
	
	public static void addCar() {

	  JFrame frame = new JFrame("Add Car");
		JLabel label = new JLabel("Add Car");
			
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
			
		JTextField CarID,VIN,Make,Model,Year,Color;
			
		CarID = new JTextField("Enter Car ID");
		VIN = new JTextField("Enter VIN");
		Make = new JTextField("Enter Make");
		Model = new JTextField("Enter Model");
		Year = new JTextField("Enter Year");
		Color = new JTextField("Enter Color");
			
		CarID.setBounds(50,100, 200,30);  
		VIN.setBounds(50,100, 200,30);  
		Make.setBounds(50,100, 200,30);  
		Model.setBounds(50,100, 200,30);  
		Year.setBounds(50,100, 200,30);  
		Color.setBounds(50,100, 200,30);  
			
		JButton Submit = new JButton();
		Submit.setText("Submit");
			
		panel.add(label);
		panel.add(CarID);
		panel.add(VIN);
		panel.add(Make);
		panel.add(Model);
		panel.add(Year);
		panel.add(Color);
		panel.add(Submit);
			
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
			
		Submit.addActionListener(new ActionListener(){
			
		  public void actionPerformed( ActionEvent f ){
					
			  String CarIDInput =CarID.getText(); 
				String VINInput =CarID.getText(); 
				String MakeInput =CarID.getText(); 
				String ModelInput =CarID.getText(); 
				String YearInput =CarID.getText(); 
				String ColorInput =CarID.getText(); 
					
				try{
						
				  Class.forName("org.sqlite.JDBC");
          //Change below after "sqlite:F:" to your database file location
					con = DriverManager.getConnection("jdbc:sqlite:F:/School_Fall_Semester_2017/Database_Systems/UsedCars.db"); 
					System.out.println("Opened database successfully");
						
					stmt = con.createStatement();
						
					stmt.executeUpdate("INSERT INTO Cars(CarID) VALUES ('"+CarIDInput+"')");	
						
					con.close();
					
				}
					
				catch ( Exception e ) {
				    	  
				  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					System.exit(0);
			 
				}	
			}
		});
	}
	
	public static void main(String[] args) {
		
	  HomeView();
		
	}
}

