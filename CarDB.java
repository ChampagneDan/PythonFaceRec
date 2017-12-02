import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.sql.*;
import javax.swing.BoxLayout;

public class CarDB{
	
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
		JButton AddCustomer = new JButton();
		JButton AddSale = new JButton();
		
		AddCar.setText("Add Car");
		AddEmployee.setText("Add Employee");
		AddSale.setText("Add Sale");
		AddCustomer.setText("Add Customer");
		ViewDataBase.setText("View Data Base");
		
		frame.getContentPane().add(label);
		frame.getContentPane().add(AddCar);
		frame.getContentPane().add(AddEmployee);
		frame.getContentPane().add(AddCustomer);
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
		AddCustomer.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
				addCustomer(); 
	        }  
		});
	}
	
	//Add Car =======================================================================================
	public static void addCar() {

		JFrame frame = new JFrame("Add Car");
		JLabel label = new JLabel("Add Car");
			
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
			
		JTextField CarID,Make,Model,Year,Color,Price,Forsale;
			
		CarID = new JTextField("Enter Car ID");
		Make = new JTextField("Enter Make");
		Model = new JTextField("Enter Model");
		Year = new JTextField("Enter Year");
		Color = new JTextField("Enter Color");
		Price = new JTextField("Enter Listing Price");
		Forsale = new JTextField("Forsale: Enter Yes or No"); 
		
		CarID.setBounds(50,100, 200,30);  
		Make.setBounds(50,100, 200,30);  
		Model.setBounds(50,100, 200,30);  
		Year.setBounds(50,100, 200,30);  
		Color.setBounds(50,100, 200,30);  
			
		JButton Submit = new JButton();
		Submit.setText("Submit");
			
		frame.getContentPane().add(label);
		frame.getContentPane().add(CarID);
		frame.getContentPane().add(Make);
		frame.getContentPane().add(Model);
		frame.getContentPane().add(Year);
		frame.getContentPane().add(Color);
		frame.getContentPane().add(Price);
		frame.getContentPane().add(Forsale);
		frame.getContentPane().add(Submit);
			
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
			
		Submit.addActionListener(new ActionListener(){
			
		  public void actionPerformed( ActionEvent f ){
					
			    String CarIDInput =CarID.getText(); 
				String MakeInput =Make.getText(); 
				String ModelInput =Model.getText(); 
				String YearInput =Year.getText(); 
				String ColorInput =Color.getText(); 
				String PriceInput =Price.getText();
				String ForsaleInput = Forsale.getText();
					
				try{
					
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:F:/School_Fall_Semester_2017/Database_Systems/UsedCars.db");
					System.out.println("Opened database successfully");
					
					stmt = con.createStatement();
					
					stmt.executeUpdate("INSERT INTO Cars(CarID,Make,Model,Year,Color,Price,Forsale) VALUES ('"+CarIDInput+"','"+MakeInput+"','"+ModelInput+"','"+YearInput+"','"+ColorInput+"','"+PriceInput+"','"+ForsaleInput+"')");	
					
					con.close();

				}
					
				catch ( Exception e ) {
				    	  
				  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					System.exit(0);
			 
				}	
			}
		});
	}
	//=======================================================================================
	
	//Add Employee=======================================================================================
	public static void addEmployee() {

		JFrame frame = new JFrame("Add Employee");
		JLabel label = new JLabel("Add Employee");
				
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
		JTextField EmployeeID,FirstName,LastName,DOB,DateOfEmployment,Wage;
				
		EmployeeID = new JTextField("Enter Employee ID");
		FirstName = new JTextField("Enter First Name");
		LastName = new JTextField("Enter Last Name");
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
		frame.getContentPane().add(LastName);
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
				String FirstNameInput =FirstName.getText(); 
				String LastNameInput =LastName.getText(); 
				String DOBInput =DOB.getText(); 
				String DateOfEmploymentInput =DateOfEmployment.getText(); 
				String WageInput =Wage.getText(); 
						
				try{
						
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:F:/School_Fall_Semester_2017/Database_Systems/UsedCars.db");
					System.out.println("Opened database successfully");
						
					stmt = con.createStatement();
						
					stmt.executeUpdate("INSERT INTO Employees(EmployeeID,FirstName,LastName,DOB,DateOfEmployment,Wage) VALUES ('"+EmployeeIDInput+"','"+FirstNameInput+"','"+LastNameInput+"','"+DOBInput+"','"+DateOfEmploymentInput+"','"+WageInput+"')");	
						
					con.close();

				}
						
				catch ( Exception e ) {
					    	  
					System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					System.exit(0);
				 
				}	
			}
		});
	}
	//=======================================================================================
	
	//Add Customer=======================================================================================
	public static void addCustomer() {

		JFrame frame = new JFrame("Add Customer");
		JLabel label = new JLabel("Add Customer");
				
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
		JTextField CustomerID,FirstName,LastName,DOB,PhoneNumber;
				
		CustomerID = new JTextField("Enter CustomerID");
		FirstName = new JTextField("Enter customers First Name");
		LastName = new JTextField("Enter customers Last Name");
		DOB = new JTextField("Enter customers DOB");
		PhoneNumber = new JTextField("Enter customers Phone Number");
			
		CustomerID.setBounds(50,100, 200,30);  
		FirstName.setBounds(50,100, 200,30);  
		LastName.setBounds(50,100, 200,30);  
		DOB.setBounds(50,100, 200,30);  
		PhoneNumber.setBounds(50,100, 200,30);  
				
		JButton Submit = new JButton();
		Submit.setText("Submit");
				
		frame.getContentPane().add(label);
		frame.getContentPane().add(CustomerID);
		frame.getContentPane().add(FirstName);
		frame.getContentPane().add(LastName);
		frame.getContentPane().add(DOB);
		frame.getContentPane().add(PhoneNumber);
		frame.getContentPane().add(Submit);
				
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
		Submit.addActionListener(new ActionListener(){
				
			public void actionPerformed( ActionEvent f ){
						
				String CustomerIDInput =CustomerID.getText(); 
				String FirstNameInput =FirstName.getText(); 
				String LastNameInput =LastName.getText(); 
				String DOBInput =DOB.getText(); 
				String PhoneNumberInput =PhoneNumber.getText(); 
						
				try{
						
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:F:/School_Fall_Semester_2017/Database_Systems/UsedCars.db");
					System.out.println("Opened database successfully");
						
					stmt = con.createStatement();
						
					stmt.executeUpdate("INSERT INTO Customers(CustomerID,FirstName,LastName,DOB,PhoneNumber) VALUES ('"+CustomerIDInput+"','"+FirstNameInput+"','"+LastNameInput+"','"+DOBInput+"','"+PhoneNumberInput+"')");	
						
					con.close();

				}
						
				catch ( Exception e ) {
					    	  
					System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					System.exit(0);
				 
				}	
			}
		});
	}
	
	//Add Sale=======================================================================================
	public static void addSale() {

		JFrame frame = new JFrame("Add Sale");
		JLabel label = new JLabel("Add Sale");
				
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
		JTextField SaleID,CarID,CustomerID,EmployeeID,DateOfSale,SalePrice;
				
		SaleID = new JTextField("Enter Sale ID");
		CarID = new JTextField("Enter CarID");
		CustomerID = new JTextField("Enter CustomerID");
		EmployeeID = new JTextField("Enter EmployeeID");
		DateOfSale = new JTextField("Enter Date Of Sale");
		SalePrice = new JTextField("Enter Sale Price");
			
				
		SaleID.setBounds(50,100, 200,30);  
		CarID.setBounds(50,100, 200,30);  
		CustomerID.setBounds(50,100, 200,30);  
		EmployeeID.setBounds(50,100, 200,30);  
		DateOfSale.setBounds(50,100, 200,30);  
		SalePrice.setBounds(50,100, 200,30);  
				
		JButton Submit = new JButton();
		Submit.setText("Submit");
				
		frame.getContentPane().add(label);
		frame.getContentPane().add(SaleID);
		frame.getContentPane().add(CarID);
		frame.getContentPane().add(CustomerID);
		frame.getContentPane().add(EmployeeID);
		frame.getContentPane().add(DateOfSale);
		frame.getContentPane().add(SalePrice);
		frame.getContentPane().add(Submit);
				
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
		Submit.addActionListener(new ActionListener(){
				
			public void actionPerformed( ActionEvent f ){
						
				String SaleIDInput =SaleID.getText();
				String CarIDInput =CarID.getText(); 
				String CustomerIDInput =CustomerID.getText(); 
				String EmployeeIDInput =EmployeeID.getText(); 
				String DateOfSaleInput =DateOfSale.getText(); 
				String SalePriceInput =SalePrice.getText(); 
						
				try{
						
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:F:/School_Fall_Semester_2017/Database_Systems/UsedCars.db");
					System.out.println("Opened database successfully");
						
					stmt = con.createStatement();
						
					stmt.executeUpdate("INSERT INTO Sales(SaleID,CarID,CustomerID,EmployeeID,DateOfSale,SalePrice) VALUES ('"+SaleIDInput+"','"+CarIDInput+"','"+CustomerIDInput+"','"+EmployeeIDInput+"','"+DateOfSaleInput+"','"+SalePriceInput+"')");	
						
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
