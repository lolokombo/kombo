package Kalendarz_projekt;

public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private int permissions;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getPrzyzwolenie() {
		return permissions;
	}
	public void setPrzyzwolenie(int permissions) {
		this.permissions = permissions;
	}

	public Person() {
		
	}
		
	public String toString () {
		return "Person name: " + this.firstName;
	}	
}
