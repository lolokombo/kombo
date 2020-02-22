package Kalendarz_projekt;

import java.util.ArrayList;
import java.util.List;

public class MiesiacManager {
	
	private List<Miesiac> miesiace;
	private MiesiacDBLayer miesiaceDB;
	
	public MiesiacManager () {
		miesiaceDB = new MiesiacDBLayer();
		miesiace = new ArrayList<Miesiac>();
	}
	public void addMiesiac (Miesiac m) throws Exception {
		miesiaceDB.addMiesiac(m);
		miesiace.add(m);
	}
	
	public Boolean removeMiesiac (int id) throws Exception {
		Miesiac tempMiesiac = null;
		for (Miesiac m : miesiace)
			if (m.getId()==(id)) {
				tempMiesiac = m;
				break;
			}
		if (tempMiesiac != null) {
			removeMiesiac(tempMiesiac);
			return true;
		}
		else
			return false;
	}
	
	public void removeMiesiac (Miesiac m) throws Exception {
		miesiaceDB.removeMiesiac(m);
		miesiace.remove(m);
	}
	
	public List<Miesiac> readMiesiace() throws Exception {
		this.miesiace = miesiaceDB.getMiesiac();
		return this.miesiace;
	}
	
	public List<Miesiac> getMiesiace() throws Exception {
		if (this.miesiace == null || this.miesiace.size() == 0)
			this.miesiace = miesiaceDB.getMiesiac();
		return this.miesiace;
	}
	
	public Miesiac getMiesiac (int miesiacid, String miesiacName) {
		for (Miesiac m : miesiace)
			if (m.getId()==miesiacid && m.getMiesiacName().equals(miesiacName)){
				return m;
			}
		return null;
	}


}
