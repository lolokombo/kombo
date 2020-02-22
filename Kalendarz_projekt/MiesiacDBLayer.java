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
	
	public void addMiesiac(Miesiac mies) throws Exception {
	Connection connection = null;
	try {
		Class.forName("org.sqlite.JDBC");
    	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Kalendarz.db");
    	Statement statement = connection.createStatement();
    	statement.setQueryTimeout(30); 
    	String sql = "INSERT INTO Miesiace (MiesiacName) values(?)";
    	
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,mies.getMiesiacName());
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

public void removeMiesiac (Miesiac mies) throws Exception {
	Connection connection = null;
	try {
		Class.forName("org.sqlite.JDBC");
        	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Kalendarz.db");
        	Statement statement = connection.createStatement();
        	statement.setQueryTimeout(30); 
        	statement.executeUpdate("DELETE FROM Miesiace WHERE MiesiacName='"+ mies.getId() + "'");
        
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

public List<Miesiac> getMiesiac () throws Exception {
	List<Miesiac> listOfMiesiace = new ArrayList<Miesiac>();
	
	Connection connection = null;
	try {
		Class.forName("org.sqlite.JDBC");
         	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Kalendarz.db");
         	Statement statement = connection.createStatement();
         	statement.setQueryTimeout(30); 
         	ResultSet resultSet = statement.executeQuery("SELECT MiesiacID, MiesiacName");
         	while(resultSet.next())
         	{
         		Miesiac newMiesiac = new Miesiac();
        	 	newMiesiac.setId(resultSet.getInt("MiesiacID"));
        	 	newMiesiac.setMiesiacName(resultSet.getString("MiesiacName"));
        	 	listOfMiesiace.add(newMiesiac);
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
	return listOfMiesiace;
	
}

}
