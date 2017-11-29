import java.sql.*;

public class Main {
  
	public static void main( String args[] ) {
      
		Connection c = null;
		Statement stmt = null;
      
		try{
         
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:F:/School_Fall_Semester_2017/Database_Systems/UsedCars.db");

			System.out.println("Opened database successfully");
      
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM CARS;" );
      
			while ( rs.next() ) {
    		  
				String id = rs.getString("CarID");
				String  vin = rs.getString("VIN");
				String  make = rs.getString("MAKE");
				String  model = rs.getString("MODEL");
				int  year = rs.getInt("YEAR");
				String color = rs.getString("Color");
				float price = rs.getFloat("PRICE");
				boolean forsale = rs.getBoolean("FORSALE");

				System.out.println( "CarID = " + id );
				System.out.println( "VIN = " + vin );
				System.out.println( "MAKE = " + make );
				System.out.println( "MODEL = " + model );
				System.out.println( "YEAR = " + year );
				System.out.println( "COLOR = " + color );
				System.out.println( "PRICE = " + price );
				System.out.println( "FORSALE = " + forsale );
				System.out.println();
			}
      
			rs.close();
			stmt.close();
			c.close();
		}  
      	
		catch ( Exception e ) {
    	  
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
 
		}
	}
}
      
      
      
