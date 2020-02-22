package Kalendarz_projekt;

public class Wpis {
	
	private int iD;
	private String wpis;
	private String wpisdata;
	
	public int getId() {
		return iD;
	}

	public void setId(int iD) {
		this.iD = iD;
	}

	public String getWpis() {
		return wpis;
	}

	public void setWpis(String wpis) {
		this.wpis = wpis;
	}
	
	public String getWpisData() {
		return wpisdata;
	}

	public void setWpisData(String wpisdata) {
		this.wpisdata = wpisdata;
	}

	public String toString() {
		return this.iD + wpis + wpisdata; 
	}
}
