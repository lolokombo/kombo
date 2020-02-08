package Kalendarz_projekt;

import java.util.ArrayList;
import java.util.List;


public class PersonManager {
	private List<Person> persons;
	private PersonDBLayer personsDB;
	
	public PersonManager () {
		personsDB = new PersonDBLayer();
		persons = new ArrayList<Person>();
	}
	public Person loginPerson (String firstName, String lastName, String password) throws Exception{
		return personsDB.loginPerson(firstName , lastName , password);
	}
	
	public void addPerson (Person p) throws Exception {
		personsDB.addPerson(p);
		persons.add(p);
	}
	
	public Boolean removePerson (int id) throws Exception {
		Person tempPerson = null;
		for (Person p : persons)
			if (p.getId()==(id)) {
				tempPerson = p;
				break;
			}
		if (tempPerson != null) {
			removePerson(tempPerson);
			return true;
		}
		else
			return false;
	}
	
	public void removePerson (Person p) throws Exception {
		personsDB.removePerson(p);
		persons.remove(p);
	}
	
	public List<Person> readPersons() throws Exception {
		this.persons = personsDB.getPersons();
		return this.persons;
	}
	
	public List<Person> getPersons() throws Exception {
		if (this.persons == null || this.persons.size() == 0)
			this.persons = personsDB.getPersons();
		return this.persons;
	}
	
	public Person getPerson (String name, String lastName) {
		for (Person p : persons)
			if (p.getFirstName().equals(name) && p.getLastName().equals(lastName)){
				return p;
			}
		return null;
	}

}
