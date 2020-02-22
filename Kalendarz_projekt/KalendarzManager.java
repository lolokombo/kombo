package Kalendarz_projekt;

import java.util.Scanner;

public class KalendarzManager {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonManager oc = new PersonManager();
		WpisManager wm = new WpisManager();
		MiesiacManager mm = new MiesiacManager();
		
		Scanner scan = new Scanner(System.in);
		Boolean con = true;
		do {
			System.out.println("Podaj Operacje");
			System.out.println("[1]. Logowanie");
			System.out.println("[2]. Rejestracja");
			String operation = scan.nextLine();
			if ("1".equals(operation)) {
				System.out.println("Podaj imie");
				String name = scan.nextLine();
				System.out.println("Podaj nazwisko");
				String lastName = scan.nextLine();
				System.out.println("Podaj hasło");
				String password = scan.nextLine();
				try {
					Person p = oc.loginPerson(name, lastName, password);
					if (p != null) {
						if (p.getPrzyzwolenie() == 1 ) {
							Boolean cot = true;
							do {
									System.out.println("użytkownik");
									System.out.println("Co chcesz zrobić?");
									System.out.println("[1]. Dodaj wpis");
									System.out.println("[2]. Usun wpis");
									System.out.println("[3]. Pokasz wszystkie wpisy");
									System.out.println("[4]. Koniec działania aplikacji");
									String operation2 = scan.nextLine();
									if ("1".equals(operation2)){
										System.out.println("Podaj numer wpisu");
										int wpisid = scan.nextInt();
										scan.nextLine();
										System.out.println("Podaj zawartość wpisy");
										String wpis = scan.nextLine();
										System.out.println("Podaj date wpisu");
										String wpisdata = scan.nextLine();
										Wpis wwp1 = new Wpis();
										wwp1.setId(wpisid);
										wwp1.setWpis(wpis);
										wwp1.setWpisData(wpisdata);
										try {
											wm.addWpis(wwp1);
										} catch (Exception e) {
											System.out.println("Błąd w trakcie dodawania osoby: " + e);
											e.printStackTrace();
										}
										
									}else if ("2".equals(operation2)) {
										System.out.println("Podaj ID wpisy");
										System.out.println("Lista wpisów:");
										try {
											for (Wpis wwp1 : wm.getWpisy()) {
												System.out.println(wwp1);
											}
										} catch (Exception e) {
											System.out.println("Błąd w trakcie wyświetlania listy wpisów: " + e);
											e.printStackTrace();
										}
										int WpisId = scan.nextInt();
										try {
											if (!wm.removeWpis(WpisId))
												System.out.println("Wpisu nie ma na liście");
											else
												System.out.println("Usunięto Wpis z listy");
										} catch (Exception e) {
											System.out.println("Błąd w trakcie usuwania wpisu: " + e);
											e.printStackTrace();
										}
									}else if ("3".equals(operation2)) {
										System.out.println("Lista wpisów:");
										try {
											for (Wpis wwp1 : wm.getWpisy()) {
												System.out.println(wwp1);
											}
										} catch (Exception e) {
											System.out.println("Błąd w trakcie wyświetlania listy osób: " + e);
											e.printStackTrace();
											}
									} else if ("4".equals(operation2)) {
										System.out.println("Bye.");
										con = false;
									} else {
										System.out.println("Nieprawidłowa operacja");
									}
									
							}while (cot);
						}
					} else {
							Boolean connt = true;
							do {
								System.out.println("administrato");
								System.out.println("Co chcesz zrobić?");
								System.out.println("[1]. Dodaj wpis");
								System.out.println("[2]. Usun wpis");
								System.out.println("[3]. Pokasz wszystkie wpisy");
								System.out.println("[4]. Dodaj osobe");
								System.out.println("[5]. Usun osobe");
								System.out.println("[6]. Wyswietl liste osób");
								System.out.println("[7]. Dodaj Miesiąc");
								System.out.println("[8]. Usun Miesiąc");
								System.out.println("[9]. Pokaż liste Miesięcy");
								System.out.println("[10]. Koniec działania aplikacji");
								String operation1 = scan.nextLine();
								if ("1".equals(operation1)){
									System.out.println("Podaj numer wpisu");
									int wpisid = scan.nextInt();
									scan.nextLine();
									System.out.println("Podaj zawartość wpisy");
									String wpis = scan.nextLine();
									System.out.println("Podaj date wpisu");
									String wpisdata = scan.nextLine();
									Wpis wwp1 = new Wpis();
									wwp1.setId(wpisid);
									wwp1.setWpis(wpis);
									wwp1.setWpisData(wpisdata);
									try {
										wm.addWpis(wwp1);
									} catch (Exception e) {
										System.out.println("Błąd w trakcie dodawania osoby: " + e);
										e.printStackTrace();
									}
									System.out.println("Dodano wpis");
								}else if ("2".equals(operation1)) {
									System.out.println("Podaj ID wpisy");
									System.out.println("Lista wpisów:");
									try {
										for (Wpis wwp1 : wm.getWpisy()) {
											System.out.println(wwp1);
										}
									} catch (Exception e) {
										System.out.println("Błąd w trakcie wyświetlania listy wpisów: " + e);
										e.printStackTrace();
									}
									int WpisId = scan.nextInt();
									try {
										if (!wm.removeWpis(WpisId))
											System.out.println("Wpisu nie ma na liście");
										else
											System.out.println("Usunięto Wpis z listy");
									} catch (Exception e) {
										System.out.println("Błąd w trakcie usuwania wpisu: " + e);
										e.printStackTrace();
									}
								}else if ("3".equals(operation1)) {
									System.out.println("Lista wpisów:");
									try {
										for (Wpis wwp1 : wm.getWpisy()) {
											System.out.println(wwp1);
										}
									} catch (Exception e) {
										System.out.println("Błąd w trakcie wyświetlania listy osób: " + e);
										e.printStackTrace();
										}	
								}else if("4".equals(operation1)) {
									System.out.println("Podaj imie");
									String imie = scan.nextLine();
									System.out.println("Podaj nazwisko");
									String nazwisko = scan.nextLine();
									System.out.println("Podaj hasło");
									String haslo = scan.nextLine();
									Person p1 = new Person();
									p1.setFirstName(imie);
									p1.setLastName(nazwisko);
									p1.setPassword(haslo);
									try {
										oc.addPerson(p1);
									} catch (Exception e) {
										System.out.println("Błąd w trakcie dodawania osoby: " + e);
										e.printStackTrace();
									}
								} else if("5".equals(operation1)) {
									System.out.println("Podaj ID");
									System.out.println("Lista osób:");
									try {
										for (Person p1 : oc.getPersons()) {
											System.out.println(p1);
										}
									} catch (Exception e) {
										System.out.println("Błąd w trakcie wyświetlania listy osób: " + e);
										e.printStackTrace();
									}
									int personsID = scan.nextInt();
									scan.nextLine();
									try {
										if (!oc.removePerson(personsID))
											System.out.println("Osoby nie ma na liście");
										else
											System.out.println("Usunięto osoby z listy");
									} catch (Exception e) {
										System.out.println("Błąd w trakcie usuwania osoby: " + e);
										e.printStackTrace();
									}				
									}else if ("6".equals(operation1)) {
										System.out.println("Lista osób:");
										try {
											for (Person p1 : oc.getPersons()) {
												System.out.println(p1);
											}
										} catch (Exception e) {
											System.out.println("Błąd w trakcie wyświetlania listy osób: " + e);
											e.printStackTrace();
											}
									}else if("7".equals(operation1)){
										System.out.println("Podaj Miesiac");
										String mname = scan.nextLine();
										Miesiac m1 = new Miesiac();
										m1.setMiesiacName(mname);
										try {
											mm.addMiesiac(m1);
										} catch (Exception e) {
											System.out.println("Błąd w trakcie dodawania osoby: " + e);
											e.printStackTrace();
										}
											
									}else if("8".equals(operation1)){
										System.out.println("Podaj ID");
										System.out.println("Lista miesięcy:");
										try {
											for (Miesiac m : mm.getMiesiace()) {
												System.out.println(m);
											}
										} catch (Exception e) {
											System.out.println("Błąd w trakcie wyświetlania listy miesiecy: " + e);
											e.printStackTrace();
										}
										int miesiaceID = scan.nextInt();
										scan.nextLine();
										try {
											if (!oc.removePerson(miesiaceID))
												System.out.println("Miesiaca nie ma na liście");
											else
												System.out.println("Usunięto miesiac z listy");
										} catch (Exception e) {
											System.out.println("Błąd w trakcie usuwania miesiaca: " + e);
											e.printStackTrace();
										}
											
									}else if("9".equals(operation1)){
										System.out.println("Lista miesięcy:");
										try {
											for (Miesiac m  : mm.getMiesiace()) {
												System.out.println(m);
											}
										} catch (Exception e) {
											System.out.println("Błąd w trakcie wyświetlania listy osób: " + e);
											e.printStackTrace();
											}
											
									} else if ("10".equals(operation1)) {
										System.out.println("Bye.");
										con = false;
										connt = false;
									}else {
										System.out.println("Nieprawidłowa operacja");
									}
							}
							
					while(connt);
					
					}
				} catch (Exception ex) {
					System.out.println("");
					ex.printStackTrace();
				}
			} else if ("2".equals(operation)) {
				System.out.println("Podaj imie");
				String name = scan.nextLine();
				System.out.println("Podaj nazwisko");
				String lastName = scan.nextLine();
				System.out.println("Podaj hasło");
				String password = scan.nextLine();
				Person p1 = new Person();
				p1.setFirstName(name);
				p1.setLastName(lastName);
				p1.setPassword(password);
				try {
					oc.addPerson(p1);
				} catch (Exception e) {
					System.out.println("Błąd w trakcie dodawania osoby: " + e);
					e.printStackTrace();
				}
			}	
		}while (con);
		scan.close();
	}
}