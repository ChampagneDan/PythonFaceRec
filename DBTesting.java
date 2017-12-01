package dbp;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.sql.*;
import javax.swing.BoxLayout;

public class DBTesting {
	
	static Connection con;
	static Statement stmt;
	
	public static void HomeView(){
		
		JFrame frame = new JFrame("Home");
		
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
			
		JLabel label = new JLabel("Welcome to the USED CAR DataBase");
			
		JButton AddCar = new JButton();
		JButton ViewDataBase = new JButton();
		JButton AddEmployee = new JButton();
		JButton AddSale = new JButton();
		
		AddCar.setText("Add Car");
		AddEmployee.setText("Add Employee");
		AddSale.setText("Add Sale");
		ViewDataBase.setText("View Data Base");
		
		frame.getContentPane().add(label);
		frame.getContentPane().add(AddCar);
		frame.getContentPane().add(AddEmployee);
		frame.getContentPane().add(AddSale);
		frame.getContentPane().add(ViewDataBase);

		frame.add(panel);
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		AddCar.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
			  addCar(); 
	        }  
	  });
		AddEmployee.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
			  addEmployee(); 
	        }  
	  });
		AddSale.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
			  addSale(); 
	        }  
	  });
	}
	
	public static void addCar() {

	  JFrame frame = new JFrame("Add Car");
		JLabel label = new JLabel("Add Car");
			
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
			
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
			
		frame.getContentPane().add(label);
		frame.getContentPane().add(CarID);
		frame.getContentPane().add(VIN);
		frame.getContentPane().add(Make);
		frame.getContentPane().add(Model);
		frame.getContentPane().add(Year);
		frame.getContentPane().add(Color);
		frame.getContentPane().add(Submit);
			
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
			
		Submit.addActionListener(new ActionListener(){
			
		  public void actionPerformed( ActionEvent f ){
					
			    String CarIDInput =CarID.getText(); 
				String MakeInput =CarID.getText(); 
				String ModelInput =CarID.getText(); 
				String YearInput =CarID.getText(); 
				String ColorInput =CarID.getText(); 
					
				try{
						
				    Class.forName("org.sqlite.JDBC");
          //Change below after "sqlite:F:" to your database file location
					con = DriverManager.getConnection("jdbc:sqlite:/users/cjlaptop/Desktop/UsedCars.db"); 
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
	public static void addEmployee() {

		  JFrame frame = new JFrame("Add Employee");
			JLabel label = new JLabel("Add Employee");
				
			JPanel panel = new JPanel();
			frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
			JTextField EmployeeID,FirstName,DOB,DateOfEmployment,Wage;
				
			EmployeeID = new JTextField("Enter Employee ID");
			FirstName = new JTextField("Enter First Name");
			DOB = new JTextField("Enter DOB");
			DateOfEmployment = new JTextField("Enter Date Of Employment");
			Wage = new JTextField("Enter Wage");
			
				
			EmployeeID.setBounds(50,100, 200,30);  
			FirstName.setBounds(50,100, 200,30);  
			DOB.setBounds(50,100, 200,30);  
			DateOfEmployment.setBounds(50,100, 200,30);  
			Wage.setBounds(50,100, 200,30);  
				
			JButton Submit = new JButton();
			Submit.setText("Submit");
				
			frame.getContentPane().add(label);
			frame.getContentPane().add(EmployeeID);
			frame.getContentPane().add(FirstName);
			frame.getContentPane().add(DOB);
			frame.getContentPane().add(DateOfEmployment);
			frame.getContentPane().add(Wage);
			frame.getContentPane().add(Submit);
				
			frame.add(panel);
			frame.setSize(400, 400);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
				
			Submit.addActionListener(new ActionListener(){
				
			  public void actionPerformed( ActionEvent f ){
						
				    String EmployeeIDInput =EmployeeID.getText(); 
					String FirstNameInput =EmployeeID.getText(); 
					String DOBInput =EmployeeID.getText(); 
					String DateOfEmploymentInput =EmployeeID.getText(); 
					String WageInput =EmployeeID.getText(); 
						
					try{
							
					    Class.forName("org.sqlite.JDBC");
	          //Change below after "sqlite:F:" to your database file location
						con = DriverManager.getConnection("jdbc:sqlite:/users/cjlaptop/Desktop/UsedCars.db"); 
						System.out.println("Opened database successfully");
							
						stmt = con.createStatement();
							
						stmt.executeUpdate("INSERT INTO Employee(EmplyeeID) VALUES ('"+EmployeeIDInput+"')");	
							
						con.close();
						
					}
						
					catch ( Exception e ) {
					    	  
					  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
						System.exit(0);
				 
					}	
				}
			});
		}
	
	public static void addSale() {

		  JFrame frame = new JFrame("Add Sale");
			JLabel label = new JLabel("Add Sale");
				
			JPanel panel = new JPanel();
			frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
			JTextField SaleID,CarID,CustomerID,EmployeeID,DateOfSale,SalePrice;
				
			SaleID = new JTextField("Enter Sale ID");
			CustomerID = new JTextField("Enter CustomerID");
			CarID = new JTextField("Enter CarID");
			EmployeeID = new JTextField("Enter EmployeeID");
			DateOfSale = new JTextField("Enter Date Of Sale");
			SalePrice = new JTextField("Enter Sale Price");
			
				
			SaleID.setBounds(50,100, 200,30);  
			CustomerID.setBounds(50,100, 200,30);  
			CarID.setBounds(50,100, 200,30);  
			EmployeeID.setBounds(50,100, 200,30);  
			DateOfSale.setBounds(50,100, 200,30);  
			SalePrice.setBounds(50,100, 200,30);  
				
			JButton Submit = new JButton();
			Submit.setText("Submit");
				
			frame.getContentPane().add(label);
			frame.getContentPane().add(EmployeeID);
			frame.getContentPane().add(CustomerID);
			frame.getContentPane().add(CarID);
			frame.getContentPane().add(DateOfSale);
			frame.getContentPane().add(SalePrice);
			frame.getContentPane().add(Submit);
				
			frame.add(panel);
			frame.setSize(400, 400);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
				
			Submit.addActionListener(new ActionListener(){
				
			  public void actionPerformed( ActionEvent f ){
						
				    String EmployeeIDInput =EmployeeID.getText(); 
					String CustomerIDInput =EmployeeID.getText(); 
					String CarIDInput =EmployeeID.getText(); 
					String DateOfSaleInput =EmployeeID.getText(); 
					String SalePriceInput =EmployeeID.getText(); 
						
					try{
							
					    Class.forName("org.sqlite.JDBC");
	          //Change below after "sqlite:F:" to your database file location
						con = DriverManager.getConnection("jdbc:sqlite:/users/cjlaptop/Desktop/UsedCars.db"); 
						System.out.println("Opened database successfully");
							
						stmt = con.createStatement();
							
						stmt.executeUpdate("INSERT INTO Sale(EmployeeID) VALUES ('"+EmployeeIDInput+"')");	
							
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
