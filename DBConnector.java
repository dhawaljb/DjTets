package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	static Connection con;
	
	static String result;
	
	public static String setConnection(String DBUrl, String Username, String Password, String dbQuery) throws SQLException, Exception{
		
		try {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//Creating connection to the database
		con = DriverManager.getConnection(DBUrl, Username, Password);
		
        //Creating statement object
    	Statement st = con.createStatement();
       	
        //Executing the SQL Query and store the results in ResultSet
    	ResultSet rs = st.executeQuery(dbQuery);
    	
    	while (rs.next()) {
    		//System.out.println(rs.getString("ingredient_name"));
    		result =  rs.getString(1);
	
    	}
 
	}
		catch(NullPointerException e)
		
		{
			System.out.println(e);
		
		if (con != null) {
    		con.close();
    		}
		
		}  
		
		finally {
			
			if (con != null) {
	    		con.close();
	    		System.out.println("DB Connection Closed......");
	    		}		
			} 
		
		return result;
		
	}
}

