package Kalendarz_projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WpisDBLayer {
	
	public void addWpis(Wpis wwp) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
        	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Kalendarz.db");

        	Statement statement = connection.createStatement();
        	statement.setQueryTimeout(30); 

        	String sql = "INSERT INTO Opis (WpisID,Wpis,WpisData) values(?,?,?)";
        	
    		PreparedStatement pstmt = connection.prepareStatement(sql);
    		pstmt.setInt(1,wwp.getId());
    		pstmt.setString(2,wwp.getWpis());
    		pstmt.setString(3,wwp.getWpisData());
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
	public void removeWpis (Wpis wpp) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Kalendarz.db");

	        	Statement statement = connection.createStatement();
	        	statement.setQueryTimeout(30); 

	        	statement.executeUpdate("DELETE FROM Opis WHERE WpisID='"+ wpp.getId() + "'");
	        
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
	public List<Wpis> getWpisy () throws Exception {
		List<Wpis> listOfWpisy = new ArrayList<Wpis>();

		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	         	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Kalendarz.db");

	         	Statement statement = connection.createStatement();
	         	statement.setQueryTimeout(30); 

	         	ResultSet resultSet = statement.executeQuery("SELECT WpisID, Wpis, WpisData FROM Opis");
	         	while(resultSet.next())
	         	{
	        	 	Wpis newWpis = new Wpis();
	        	 	newWpis.setId(resultSet.getInt("WpisID"));
	        	 	newWpis.setWpis(resultSet.getString("Wpis"));
	        	 	newWpis.setWpisData(resultSet.getString("WpisData"));
	        	 	listOfWpisy.add (newWpis);
	         	}
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage()); 
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
		
		return listOfWpisy;
	}

}
