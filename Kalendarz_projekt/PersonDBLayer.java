package Kalendarz_projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PersonDBLayer {
	public Person loginPerson(String imie, String nazwisko, String haslo , int przyzwolenie) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
        	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Klendarz.db");

        	Statement statement = connection.createStatement();
        	statement.setQueryTimeout(30);
        	
        	String sql = "SELECT Id,FirstName,LastName,Password,Przyzwolenie FROM Uzytkownicy WHERE FirstName = ? AND LastName = ? AND Password = ?)";
        	
    		PreparedStatement pstmt = connection.prepareStatement(sql);
    		pstmt.setString(1,imie);
    		pstmt.setString(2,nazwisko);
    		pstmt.setString(3,haslo);
    		pstmt.setInt(4,przyzwolenie);
    		pstmt.executeQuery();
    		ResultSet resultSet = pstmt.executeQuery();
    		if (resultSet.next()) {
    			Person p = new Person ();
    			p.setFirstName(imie);
    			p.setLastName(nazwisko);
    			p.setId(resultSet.getInt(resultSet.getInt("PersonID")));
    			//odczyt uprawnien
    			p.setPrzyzwolenie(przyzwolenie);
    			return p;
    		} else {
    			return null;
    		}
    		
		} catch(SQLException e){
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
	public void addPerson(Person prsn) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
        	connection = DriverManager.getConnection("jdbc:sqlite:D:/DB/Klendarz.db");

        	Statement statement = connection.createStatement();
        	statement.setQueryTimeout(30); 

        	String sql = "INSERT INTO Persons (FirstName,LastName,Password) values(?,?,?)";
        	
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

	        	statement.executeUpdate("DELETE FROM Persons WHERE name='"+ prsn.getId() + "'");
	        
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
	
	public List<Person> getPersons () throws Exception {
		List<Person> listOfPersons = new ArrayList<Person>();

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
		
		return listOfPersons;
	}
}
