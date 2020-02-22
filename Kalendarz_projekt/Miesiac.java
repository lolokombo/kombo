package Kalendarz_projekt;

public class Miesiac {
	private int Id;
	private String miesiacname;
	
	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getMiesiacName() {
		return miesiacname;
	}

	public void setMiesiacName(String miesiacname) {
		this.miesiacname = miesiacname;
	}
	public String toString() {
		return "Miesiac name:  "+ this.Id + this.miesiacname;
	}

}
