package Kalendarz_projekt;

import java.util.ArrayList;
import java.util.List;

public class WpisManager {
	
	private List<Wpis> Wpisy;
	private WpisDBLayer WpisyDB;
	
	public WpisManager () {
		WpisyDB = new WpisDBLayer();
		Wpisy = new ArrayList<Wpis>();
	}
	
	public void addWpis (Wpis wwp) throws Exception {
		WpisyDB.addWpis(wwp);
		Wpisy.add(wwp);
	}
	
	public Boolean removeWpis (int iD) throws Exception {
		Wpis tempWpis = null;
		for (Wpis wwp : Wpisy)
			if (wwp.getId()==(iD)) {
				tempWpis = wwp;
				break;
			}
		if (tempWpis != null) {
			removeWpis(tempWpis);
			return true;
		}
		else
			return false;
	}
	
	public void removeWpis (Wpis wwp) throws Exception {
		WpisyDB.removeWpis(wwp);
		Wpisy.remove(wwp);
	}
	
	public List<Wpis> readWpisy() throws Exception {
		this.Wpisy = WpisyDB.getWpisy();
		return this.Wpisy;
	}
	
	public List<Wpis> getWpisy() throws Exception {
		if (this.Wpisy == null || this.Wpisy.size() == 0)
			this.Wpisy = WpisyDB.getWpisy();
		return this.Wpisy;
	}
	
	public Wpis getWpis (int Id, String Wpis,String wpisdata) {
		for (Wpis wwp : Wpisy)
			if (wwp.getId()==Id && wwp.getWpis().equals(Wpis) && wwp.getWpisData().equals(wpisdata)){
				return wwp;
			}
		return null;
	
	}
}
