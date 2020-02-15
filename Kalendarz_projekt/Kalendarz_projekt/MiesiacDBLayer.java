package Kalendarz_projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MiesiacDBLayer {
	
	/*public void addMiesiac(Miesiac prsn) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
        	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Kalendarz.db");

        	Statement statement = connection.createStatement();
        	statement.setQueryTimeout(30); 

        	String sql = "INSERT INTO Miesiac (FirstName,LastName,Password) values(?,?,?)";
        	
    		PreparedStatement pstmt = connection.prepareStatement(sql);
    		pstmt.setString(1,prsn.getFirstName());
    		pstmt.setString(2,prsn.getLastName());
    		pstmt.setString(3,prsn.getPassword());
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
	
	public void removePerson (Person prsn) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Kalendarz.db");

	        	Statement statement = connection.createStatement();
	        	statement.setQueryTimeout(30); 

	        	statement.executeUpdate("DELETE FROM Miesiac WHERE name='"+ prsn.getId() + "'");
	        
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
	
	public List<Miesiac> getPersons () throws Exception {
		List<Miesiac> listOfPersons = new ArrayList<Miesiac>();

		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	         	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Kalendarz.db");

	         	Statement statement = connection.createStatement();
	         	statement.setQueryTimeout(30); 

	         	ResultSet resultSet = statement.executeQuery("SELECT PersonID, FirstName, LastName");
	         	while(resultSet.next())
	         	{
	        	 	Person newPerson = new Person();
	        	 	newPerson.setId(resultSet.getInt("PersonID"));
	        	 	newPerson.setFirstName(resultSet.getString("FirstName"));
	        	 	newPerson.setLastName(resultSet.getString("LastName"));
	        	 	listOfPersons.add (newPerson);
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
		
	*/

}
