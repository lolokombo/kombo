package Kalendarz_projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class WpisDBLayer {
 
	public void addWpis(Wpis wwp) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
        	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Klendarz.db");

        	Statement statement = connection.createStatement();
        	statement.setQueryTimeout(30); 

        	String sql = "INSERT INTO Opis (OpisID,Wpis,OpisData) values(?,?,?)";
        	
    		PreparedStatement pstmt = connection.prepareStatement(sql);
    		pstmt.setInt(1,wwp.getId());
    		pstmt.setString(2,wwp.getWpis());
    		pstmt.setInt(3,wwp.getWpisData());
    		pstmt.executeUpdate();
    		

    	
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage());
	    	 	throw e;
	    	}
		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			throw e;
		}
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {          
				System.err.println(e); 
			}
	    }
	}
}
