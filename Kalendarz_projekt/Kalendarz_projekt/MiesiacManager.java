package Kalendarz_projekt;

import java.util.ArrayList;
import java.util.List;

public class MiesiacManager {
	/*private List<Miesiac> miesiace;
	private MiesiacDBLayer miesiaceDB;
	
	public MiesiacManager () {
		miesiaceDB = new PersonDBLayer();
		miesiace = new ArrayList<Person>();
	}
	public Person loginPerson (String firstName, String lastName, String password) throws Exception{
		return miesiaceDB.loginPerson(firstName , lastName , password);
	}
	
	public void addPerson (Person p) throws Exception {
		miesiaceDB.addPerson(p);
		miesiace.add(p);
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
		miesiaceDB.removePerson(p);
		miesiace.remove(p);
	}
	
	public List<Person> readPersons() throws Exception {
		this.miesiace = miesiaceDB.getPersons();
		return this.miesiace;
	}
	
	public List<Person> getPersons() throws Exception {
		if (this.miesiace == null || this.miesiace.size() == 0)
			this.miesiace = miesiaceDB.getPersons();
		return this.miesiace;
	}
	
	public Person getPerson (String name, String lastName) {
		for (Person p : miesiace)
			if (p.getFirstName().equals(name) && p.getLastName().equals(lastName)){
				return p;
			}
		return null;
	}*/

}
