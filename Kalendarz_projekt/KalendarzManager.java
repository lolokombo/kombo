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
				Person p = oc.loginPerson(name, lastName, password);
				if (p != null) {
					if (p.getPrzyzwolenie() == 1 ) {
						
					}
				} else {
					
					
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
		scan.close();
		}while (con);
	}
}