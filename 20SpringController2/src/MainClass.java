import java.util.ArrayList;
import java.util.Scanner;

// Import package classi
import classi.Persona;

public class MainClass {

	public static void main(String[] args) {

		String[] nomi = { "Marco", "Michelangelo", "Fabio", "Mario", "Marta", "Ramona", "Lorenzo" };
		String[] cognomi = { "Indovino", "Rossi", "Quartararo", "Bianchi", "Verdi", "Neri", "Gialli" };

		int dim = 10, scelta = 0;
		Scanner sc = new Scanner(System.in);

		ArrayList<Persona> lista = new ArrayList<>();
		Persona[] persone = new Persona[dim];

		for (int j = 0; j < dim; j++) {
			String nome = nomi[(int) (Math.random() * 7)];
			String cognome = cognomi[(int) (Math.random() * 7)];
			String mail = nome + "." + cognome + "@mail.it";

			lista.add(persone[j] = new Persona(j + 1, nome, cognome, mail));
		}

		while (true) {
			menuContestuale();

			try {

				scelta = Integer.parseInt(sc.nextLine());

				switch (scelta) {
				case 1: // Add person
					addPersona(lista);
					break;
				case 2: // Remove by ID
					removePersona(lista);
					break;
				case 3: // Remove by name
					removePersonaName(lista);
					break;
				case 4: // Change by ID
					editByID(lista);
					break;
				case 5: // Print list
					printList(lista);
					break;
				case 0:
					sc.close();
					System.exit(0);
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("Scelta inserita non valida. Si prega di inserire un numero valido");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// 1- Aggiungi persona alla lista
	public static void addPersona(ArrayList<Persona> lista) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci il nome: ");
		String nome = sc.nextLine();
		System.out.println("Inserisci il cognome: ");
		String cognome = sc.nextLine();
		System.out.println("Inserisci il mail: ");
		String mail = sc.nextLine();

		lista.add(new Persona(getMaxIDLista(lista) + 1, nome, cognome, mail));
	}

	// 2- Rimuovi persona da ID
	public static void removePersona(ArrayList<Persona> lista) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Inserisci ID della persona da rimuovere (min value: 1 , max value: " + lista.size() + "): ");
		
		try {
			int idDaRimuovere = Integer.parseInt(sc.nextLine());
			if (idDaRimuovere > 0 && idDaRimuovere < getMaxIDLista(lista) + 1) {
				for (int i = 1; i < lista.size() + 1; i++) {
					Persona e = lista.get(i);
					if (e.getID() == idDaRimuovere) {
						lista.remove(e);
						break;
					}
				}
			} else {
				System.out.println("Nessun ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 3- Rimuovi persona da nome
	public static void removePersonaName(ArrayList<Persona> lista) {
		Scanner sc = new Scanner(System.in);

		// Inserisco il nome della persona da eliminare
		System.out.println("Inserisci il nome da eliminare: ");
		String nome = sc.nextLine();

		// Itero la lista ed elimino gli utenti con i nomi coincidenti
		for (int i = lista.size() - 1; i >= 0; i--) {

			if (lista.get(i).getNome().equals(nome)) {
				lista.remove(i);
			}
		}
	}

	// 4- Modifica mediante ID
	public static void editByID(ArrayList<Persona> lista) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci l'ID della persona da modificare: ");

		try {
			int id = Integer.parseInt(sc.nextLine());
			int index = findByID(lista, id);

			if (index != -1) {

				System.out.println("Inserisci il nuovo nome: ");
				String nome = sc.nextLine();
				System.out.println("Inserisci il nuovo cognome: ");
				String cognome = sc.nextLine();
				System.out.println("Inserisci il nuovo mail: ");
				String mail = sc.nextLine();

				lista.get(index).modifica(nome, cognome, mail);

			} else {
				System.out.println("ID non presente!");
			}

		} catch (NumberFormatException e) {

			System.out.println("Valore non numerico inserito!Riprova.");
			editByID(lista);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 5- Stampa la lista degli utenti
	public static void printList(ArrayList<Persona> lista) {
		for (Persona p : lista)
			System.out.println("\t" + p);
	}

	static int getMaxIDLista(ArrayList<Persona> lista) {
		return lista.get(lista.size() - 1).getID();
	}

	static int findByID(ArrayList<Persona> lista, int id) {

		for (int index = 0; index < lista.size(); index++) {
			if (lista.get(index).getID() == id) {
				return index;
			}
		}

		return -1; // Ritorna -1 se non trova l'elemento
	}

	static void menuContestuale() {
		System.out.println("Menu:");
		System.out.println("1- Aggiungi");
		System.out.println("2- Rimuovi mediante ID");
		System.out.println("3- Rimuovi mediante Nome");
		System.out.println("4- Modifica mediante ID");
		System.out.println("5- Stampa lista");
		System.out.println("0- Esci");
	}
}
