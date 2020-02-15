package Kalendarz_projekt;

import java.util.Scanner;


public class KalendarzManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonManager oc = new PersonManager();
		WpisManager wm = new WpisManager();
		
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
				System.out.println("Podaj has³o");
				String password = scan.nextLine();
				try {
					Person p = oc.loginPerson(name, lastName, password);
					if (p != null) {
						if (p.getPrzyzwolenie() == 1 ) {
							Boolean cot = true;
							do {
									System.out.println("u¿ytkownik");
									System.out.println("Co chcesz zrobiæ?");
									System.out.println("[1]. Dodaj wpis");
									System.out.println("[2]. Usun wpis");
									System.out.println("[3]. Pokasz wszystkie wpisy");
									System.out.println("[4]. Koniec dzia³ania aplikacji");
									String operation2 = scan.nextLine();
									if ("1".equals(operation2)){
										System.out.println("Podaj numer wpisu");
										int wpisid = scan.nextInt();
										scan.nextLine();
										System.out.println("Podaj zawartoœæ wpisy");
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
											System.out.println("B³¹d w trakcie dodawania osoby: " + e);
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
											System.out.println("B³¹d w trakcie wyœwietlania listy wpisów: " + e);
											e.printStackTrace();
										}
										int WpisId = scan.nextInt();
										try {
											if (!wm.removeWpis(WpisId))
												System.out.println("Wpisu nie ma na liœcie");
											else
												System.out.println("Usuniêto Wpis z listy");
										} catch (Exception e) {
											System.out.println("B³¹d w trakcie usuwania wpisu: " + e);
											e.printStackTrace();
										}
									}else if ("3".equals(operation2)) {
										System.out.println("Lista wpisów:");
										try {
											for (Wpis wwp1 : wm.getWpisy()) {
												System.out.println(wwp1);
											}
										} catch (Exception e) {
											System.out.println("B³¹d w trakcie wyœwietlania listy osób: " + e);
											e.printStackTrace();
											}
									} else if ("4".equals(operation2)) {
										System.out.println("Bye.");
										con = false;
									} else {
										System.out.println("Nieprawid³owa operacja");
									}
									
							}while (cot);
						}
					} else {
							Boolean connt = true;
							do {
								System.out.println("administrato");
								System.out.println("Co chcesz zrobiæ?");
								System.out.println("[1]. Dodaj wpis");
								System.out.println("[2]. Usun wpis");
								System.out.println("[3]. Pokasz wszystkie wpisy");
								System.out.println("[4]. Dodaj osobe");
								System.out.println("[5]. Usun osobe");
								System.out.println("[6]. Wyswietl liste osób");
								System.out.println("[7]. Dodaj Miesi¹c");
								System.out.println("[8]. Usun Miesi¹c");
								System.out.println("[9]. Poka¿ liste Miesiêcy");
								System.out.println("[10]. Koniec dzia³ania aplikacji");
								String operation1 = scan.nextLine();
								if ("1".equals(operation1)){
									System.out.println("Podaj numer wpisu");
									int wpisid = scan.nextInt();
									scan.nextLine();
									System.out.println("Podaj zawartoœæ wpisy");
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
										System.out.println("B³¹d w trakcie dodawania osoby: " + e);
										e.printStackTrace();
									}
									
								}else if ("2".equals(operation1)) {
									System.out.println("Podaj ID wpisy");
									System.out.println("Lista wpisów:");
									try {
										for (Wpis wwp1 : wm.getWpisy()) {
											System.out.println(wwp1);
										}
									} catch (Exception e) {
										System.out.println("B³¹d w trakcie wyœwietlania listy wpisów: " + e);
										e.printStackTrace();
									}
									int WpisId = scan.nextInt();
									try {
										if (!wm.removeWpis(WpisId))
											System.out.println("Wpisu nie ma na liœcie");
										else
											System.out.println("Usuniêto Wpis z listy");
									} catch (Exception e) {
										System.out.println("B³¹d w trakcie usuwania wpisu: " + e);
										e.printStackTrace();
									}
								}else if ("3".equals(operation1)) {
									System.out.println("Lista wpisów:");
									try {
										for (Wpis wwp1 : wm.getWpisy()) {
											System.out.println(wwp1);
										}
									} catch (Exception e) {
										System.out.println("B³¹d w trakcie wyœwietlania listy osób: " + e);
										e.printStackTrace();
										}	
								}else if("4".equals(operation1)) {
									System.out.println("Podaj imie");
									String imie = scan.nextLine();
									System.out.println("Podaj nazwisko");
									String nazwisko = scan.nextLine();
									System.out.println("Podaj has³o");
									String haslo = scan.nextLine();
									Person p1 = new Person();
									p1.setFirstName(imie);
									p1.setLastName(nazwisko);
									p1.setPassword(haslo);
									try {
										oc.addPerson(p1);
									} catch (Exception e) {
										System.out.println("B³¹d w trakcie dodawania osoby: " + e);
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
										System.out.println("B³¹d w trakcie wyœwietlania listy osób: " + e);
										e.printStackTrace();
									}
									int personsID = scan.nextInt();
									scan.nextLine();
									try {
										if (!oc.removePerson(personsID))
											System.out.println("Osoby nie ma na liœcie");
										else
											System.out.println("Usuniêto osoby z listy");
									} catch (Exception e) {
										System.out.println("B³¹d w trakcie usuwania osoby: " + e);
										e.printStackTrace();
									}				
									}else if ("6".equals(operation1)) {
										System.out.println("Lista osób:");
										try {
											for (Person p1 : oc.getPersons()) {
												System.out.println(p1);
											}
										} catch (Exception e) {
											System.out.println("B³¹d w trakcie wyœwietlania listy osób: " + e);
											e.printStackTrace();
											}
									}else if("7".equals(operation1)){
											
									}else if("8".equals(operation1)){
											
									}else if("9".equals(operation1)){
											
									} else if ("10".equals(operation1)) {
										System.out.println("Bye.");
										con = false;
										connt = false;
									}else {
										System.out.println("Nieprawid³owa operacja");
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
				System.out.println("Podaj has³o");
				String password = scan.nextLine();
				Person p1 = new Person();
				p1.setFirstName(name);
				p1.setLastName(lastName);
				p1.setPassword(password);
				try {
					oc.addPerson(p1);
				} catch (Exception e) {
					System.out.println("B³¹d w trakcie dodawania osoby: " + e);
					e.printStackTrace();
				}
			}	
		}while (con);
		scan.close();
	}
}