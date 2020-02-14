package Kalendarz_projekt;

import java.util.Scanner;

public class KalendarzManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonManager oc = new PersonManager();
		
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
				Person p = oc.loginPerson(name, lastName, password,przyzwolenie);
				if (p != null) {
					if (p.getPrzyzwolenie() == 1 ) {
						Boolean cot = true;
						do {
								System.out.println("zalogowano użytkownika");
								System.out.println("Co chcesz zrobić?");
								System.out.println("[1]. Dodaj wpis");
								System.out.println("[2]. Usun wpis");
								System.out.println("[3]. Pokasz wszystkie wpisy");
								String operation2 = scan.nextLine();
								if ("1".equals(operation2)){
									
								}else if ("2".equals(operation2)) {
									
								}else if ("3".equals(operation2)) {
									
								}
								
						}while (cot);
					}
				} else {
						Boolean connt = true;
						do {
							System.out.println("zalogowano administratora");
							System.out.println("Co chcesz zrobić?");
							System.out.println("[1]. Dodaj wpis");
							System.out.println("[2]. Usun wpis");
							System.out.println("[3]. Pokasz wszystkie wpisy");
							System.out.println("[4]. Dodaj osobe");
							System.out.println("[5]. Usun osobe");
							System.out.println("[6]. Wyswietl liste osób");	
							System.out.println("[7]. Koniec działania aplikacji");
							String operation1 = scan.nextLine();
							if ("1".equals(operation1)) {
								
							}else if("2".equals(operation1)){
									
							}else if("3".equals(operation1)){
									
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
								System.out.println("Podaj nazwę");
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
								} else if ("7".equals(operation1)) {
									System.out.println("Bye.");
									con = false;
								} else {
									System.out.println("Nieprawidłowa operacja");
								}
						}
						
				while(connt);
				
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
			
		    scan.close();
			}
		} while (con);
	}
}	