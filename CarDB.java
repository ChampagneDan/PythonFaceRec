
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
		JLabel CarIDTxt= new JLabel("Enter the VIN of the car (Must be unique).");	
		JLabel MakeTxt= new JLabel("Enter the make of the car.");
		JLabel ModelTxt= new JLabel("Enter the model of the car.");
		JLabel YearTxt= new JLabel("Enter the year of the car.");
		JLabel ColorTxt= new JLabel("Enter the color of the car.");
		JLabel ListingPriceTxt= new JLabel("Enter the listing price(Format of: $00.00).");
		JLabel ForsaleTxt= new JLabel("Select 'Yes' if the car is for sale, 'No' if otherwise.");
		
		String[] ComboBoxPatterns = {"Yes", "No"};
		JComboBox ComboBox = new JComboBox(ComboBoxPatterns);
		
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		
		JTextField CarID,Make,Model,Year,Color,Price;
			
		CarID = new JTextField("");
		Make = new JTextField("");
		Model = new JTextField("");
		Year = new JTextField("");
		Color = new JTextField("");
		Price = new JTextField("");
		
		CarID.setBounds(50,100, 200,30);  
		Make.setBounds(50,100, 200,30);  
		Model.setBounds(50,100, 200,30);  
		Year.setBounds(50,100, 200,30);  
		Color.setBounds(50,100, 200,30);  
			
		JButton Submit = new JButton();
		Submit.setText("Submit");
			
		frame.add(CarIDTxt);
		frame.add(CarID);
		frame.add(MakeTxt);
		frame.add(Make);
		frame.add(ModelTxt);
		frame.add(Model);
		frame.add(YearTxt);
		frame.add(Year);
		frame.add(ColorTxt);
		frame.add(Color);
		frame.add(ListingPriceTxt);
		frame.add(Price);
		frame.add(ForsaleTxt);
		frame.add(ComboBox);
		frame.add(Submit);
			
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
				String ForsaleInput = ComboBox.getSelectedItem().toString();
					
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
		JLabel EmployeeIDTxt= new JLabel("Enter the employees ID(Must be unique).");
		JLabel FirstNameTxt= new JLabel("Enter the employees first name.");
		JLabel LastNameTxt= new JLabel("Enter the employees last name.");
		JLabel DOBTxt= new JLabel("Enter the employees DOB.");
		JLabel DateOfEmploymentTxt= new JLabel("Enter the date of employment.");
		JLabel WageTxt= new JLabel("Enter the employees pay per hour.(Format: $00.00).");
		
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
		JTextField EmployeeID,FirstName,LastName,DOB,DateOfEmployment,Wage;
				
		EmployeeID = new JTextField("");
		FirstName = new JTextField("");
		LastName = new JTextField("");
		DOB = new JTextField("");
		DateOfEmployment = new JTextField("");
		Wage = new JTextField("");
			
				
		EmployeeID.setBounds(50,100, 200,30);  
		FirstName.setBounds(50,100, 200,30);  
		DOB.setBounds(50,100, 200,30);  
		DateOfEmployment.setBounds(50,100, 200,30);  
		Wage.setBounds(50,100, 200,30);  
				
		JButton Submit = new JButton();
		Submit.setText("Submit");
		
		frame.add(EmployeeIDTxt);
		frame.add(EmployeeID);
		frame.add(FirstNameTxt);
		frame.add(FirstName);
		frame.add(LastNameTxt);
		frame.add(LastName);
		frame.add(DOBTxt);
		frame.add(DOB);
		frame.add(DateOfEmploymentTxt);
		frame.add(DateOfEmployment);
		frame.add(WageTxt);
		frame.add(Wage);
		frame.add(Submit);
				
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
		JLabel CustomerIDTxt= new JLabel("Enter the customers ID(Must be unique).");
		JLabel FirstNameTxt= new JLabel("Enter the customers first name.");
		JLabel LastNameTxt= new JLabel("Enter the customers last name.");
		JLabel DOBTxt= new JLabel("Enter the customers DOB.");
		JLabel PhoneNumberTxt= new JLabel("Enter the customers phone number(Format: 000-000-0000 ).");
		
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
		JTextField CustomerID,FirstName,LastName,DOB,PhoneNumber;
				
		CustomerID = new JTextField("");
		FirstName = new JTextField("");
		LastName = new JTextField("");
		DOB = new JTextField("");
		PhoneNumber = new JTextField("");
			
		CustomerID.setBounds(50,100, 200,30);  
		FirstName.setBounds(50,100, 200,30);  
		LastName.setBounds(50,100, 200,30);  
		DOB.setBounds(50,100, 200,30);  
		PhoneNumber.setBounds(50,100, 200,30);  
				
		JButton Submit = new JButton();
		Submit.setText("Submit");
				
		frame.add(CustomerIDTxt);
		frame.add(CustomerID);
		frame.add(FirstNameTxt);
		frame.add(FirstName);
		frame.add(LastNameTxt);
		frame.add(LastName);
		frame.add(DOBTxt);
		frame.add(DOB);
		frame.add(PhoneNumberTxt);
		frame.add(PhoneNumber);
		
		frame.add(Submit);
				
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
		JLabel SaleIDTxt= new JLabel("Enter the saleID(MustBeUnique).");
		JLabel CarIDTxt= new JLabel("Enter the cars VIN");
		JLabel CustomerIDTxt= new JLabel("Enter the customers ID");
		JLabel EmployeeIDTxt= new JLabel("Enter the employees ID");
		JLabel DateOfSaleTxt= new JLabel("Enter the date of the sale.");
		JLabel SalePriceTxt= new JLabel("Enter the sales price (Format: $00.00).");
				
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
		JTextField SaleID,CarID,CustomerID,EmployeeID,DateOfSale,SalePrice;
				
		SaleID = new JTextField("");
		CarID = new JTextField("");
		CustomerID = new JTextField("");
		EmployeeID = new JTextField("");
		DateOfSale = new JTextField("");
		SalePrice = new JTextField("");
			
				
		SaleID.setBounds(50,100, 200,30);  
		CarID.setBounds(50,100, 200,30);  
		CustomerID.setBounds(50,100, 200,30);  
		EmployeeID.setBounds(50,100, 200,30);  
		DateOfSale.setBounds(50,100, 200,30);  
		SalePrice.setBounds(50,100, 200,30);  
				
		JButton Submit = new JButton();
		Submit.setText("Submit");
				
		frame.add(SaleIDTxt);
		frame.add(SaleID);
		frame.add(CarIDTxt);
		frame.add(CarID);
		frame.add(CustomerIDTxt);
		frame.add(CustomerID);
		frame.add(EmployeeIDTxt);
		frame.add(EmployeeID);
		frame.add(DateOfSaleTxt);
		frame.add(DateOfSale);
		frame.add(SalePriceTxt);
		frame.add(SalePrice);
		frame.add(Submit);
				
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
