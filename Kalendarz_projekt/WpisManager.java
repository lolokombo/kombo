package Kalendarz_projekt;

import java.util.ArrayList;
import java.util.List;

public class WpisManager {
	
	private List<Wpis> Wpisy;
	private WpisDBLayer WpisyDB;
	
	public WpisManager () {
		WpisyDB = new WpisDBLayer();
		Wpisy = new ArrayList<Wpis>();
		
		public void addWpis (Wpis wwp) throws Exception {
			WpisyDB.addWpis(wwp);
			Wpisy.add(wwp);
		}
		
		public Boolean removeWpis (int iD) throws Exception {
			Wpis tempPerson = null;
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
		
		public List<Wpis> getWpisy() throws Exception {
			if (this.Wpisy == null || this.Wpisy.size() == 0)
				this.Wpisy = WpisyDB.getWpisy();
			return this.Wpisy;
		}
		
		public Wpis getWpis (int iD, String Wpis,int wpisdata) {
			for (Person p : persons)
				if (p.getFirstName().equals(name) && p.getLastName().equals(lastName)){
					return p;
				}
			return null;
		
		}
}
}
