package tb.soft;

import java.util.*;

import static tb.soft.PersonCollections.*;

/**
 * Program: Aplikacja działająca w oknie konsoli, która umożliwia testowanie 
 *          operacji wykonywanych na obiektach klasy Person.
 *    Plik: PersonConsoleApp.java
 *          
 *   Autor: Paweł Rogaliński
 *    Data: październik 2018 r.
 */
public class PersonConsoleApp {

	private static final String GREETING_MESSAGE = 
			"Program Person - wersja konsolowa\n" + 
	        "Autor: Paweł Rogaliński\n" +
			"Data:  październik 2018 r.\n";

	private static final String MENU = 
			"    M E N U   G Ł Ó W N E  \n" +
			"1 - Podaj dane nowej osoby \n" +
			"2 - Usuń dane osoby        \n" +
			"3 - Modyfikuj dane osoby   \n" +
			"4 - Wczytaj dane z pliku   \n" +
			"5 - Zapisz dane do pliku   \n" +
					"---------OPCJE PREZENTACJI DZIALANIA KOLEKCJI--------- \n 6 - Dzialanie kolekcji ArrayList \n"+
					"7 - Dzialanie kolekcji LinkedList \n"+
					"8 - Dzialanie kolekcji HashSet \n"+
					"9 - Dzialanie kolekcji TreeSet \n"+
					"10 - Dzialanie kolekcji HashMap \n"+
					"11 - Dzialanie kolekcji TreeMap \n"+
					"12 - Dzialanie HashCode() i equals()\n"+

			"0 - Zakończ program        \n";	
	
	private static final String CHANGE_MENU = 
			"   Co zmienić?     \n" + 
	        "1 - Imię           \n" + 
			"2 - Nazwisko       \n" + 
	        "3 - Rok urodzenia  \n" +
			"4 - Stanowisko     \n" +
	        "0 - Powrót do menu głównego\n";

	
	/**
	 * ConsoleUserDialog to pomocnicza klasa zawierająca zestaw
	 * prostych metod do realizacji dialogu z użytkownikiem
	 * w oknie konsoli tekstowej.
	 */
	private static final ConsoleUserDialog UI = new ConsoleUserDialog();
	private static PersonCollections PersonCollections;

	public static void wyswietlanieElementowArrayList(ArrayList<PersonCollections> peopleArrayList){
		int i=0;
		for(PersonCollections personCollections: peopleArrayList){
			System.out.println(i + "." + personCollections.getFirstName() + " " + personCollections.getLastName());
			i++;
		}
	}

	public static void main(String[] args) {
		// Utworzenie obiektu aplikacji konsolowej
		// oraz uruchomienie głównej pętli aplikacji.
		//Dodanie danych z PersonCollections

		PersonConsoleApp application = new PersonConsoleApp();
		application.runMainLoop(PersonCollections);
		// --------------------------------------------------------------------

	} 

	
	/*
	 *  Referencja do obiektu, który zawiera dane aktualnej osoby.
	 */
	private Person currentPerson = null;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PersonCollections that = (PersonCollections) o;
		return Objects.equals(person4, that.person6);
	}


	/*
	 *  Metoda runMainLoop wykonuje główną pętlę aplikacji.
	 *  UWAGA: Ta metoda zawiera nieskończoną pętlę,
	 *         w której program się zatrzymuje aż do zakończenia
	 *         działania za pomocą metody System.exit(0); 
	 */
	public void runMainLoop(PersonCollections personCollections) {
	//	UI.printMessage(GREETING_MESSAGE);

		LinkedList<PersonCollections> peopleLinkedList = new LinkedList<>();
		peopleLinkedList.add(person1);
		peopleLinkedList.add(person2);
		peopleLinkedList.add(person3);
		peopleLinkedList.add(person4);
		peopleLinkedList.add(person5);
		ArrayList<PersonCollections> peopleArrayList = new ArrayList<>();
		peopleArrayList.add(person1);
		peopleArrayList.add(person2);
		peopleArrayList.add(person3);
		peopleArrayList.add(person4);
		peopleArrayList.add(person5);
		HashSet<PersonCollections> peopleHashSet = new HashSet<>();
		peopleHashSet.add(person1);
		peopleHashSet.add(person2);
		peopleHashSet.add(person3);
		peopleHashSet.add(person4);
		peopleHashSet.add(person5);
		TreeSet<PersonCollections> peopleTreeSet = new TreeSet<>(new Comparator<PersonCollections>() {
			@Override
			public int compare(PersonCollections o1, PersonCollections o2) {
				if(o1.getLastName().equals(o2.getLastName())
						&& o1.getFirstName().equals(o2.getFirstName()))
					return 0;
				else return 1;
			}
		});
		peopleTreeSet.add(person1);
		peopleTreeSet.add(person2);
		peopleTreeSet.add(person3);
		peopleTreeSet.add(person4);
		HashMap<String,PersonCollections> peopleHashMap = new HashMap<>();
			peopleHashMap.put("Pierwszy", person1);
			peopleHashMap.put("Drugi", person2);
			peopleHashMap.put("Trzeci", person3);
			peopleHashMap.put("Czwarty", person4);
			peopleHashMap.put("Piaty", person5);
		TreeMap<String,PersonCollections> peopleTreeMap = new TreeMap<>();
			peopleTreeMap.put("Jeden", person1);
			peopleTreeMap.put("Dwa", person2);
			peopleTreeMap.put("Trzy", person3);
			peopleTreeMap.put("Cztery", person4);


		while (true) {
			UI.clearConsole();
			showCurrentPerson();

			try {
				switch (UI.enterInt(MENU + "==>> ")) {
				case 1:
					// utworzenie nowej osoby
					currentPerson = createNewPerson();
					break;
				case 2:
					// usunięcie danych aktualnej osoby.
					currentPerson = null;
					UI.printInfoMessage("Dane aktualnej osoby zostały usunięte");
					break;
				case 3:
					// zmiana danych dla aktualnej osoby
					if (currentPerson == null) throw new PersonException("Żadna osoba nie została utworzona.");
					changePersonData(currentPerson);
					break;
				case 4: {
					// odczyt danych z pliku tekstowego.
					String file_name = UI.enterString("Podaj nazwę pliku: ");
					currentPerson = Person.readFromFile(file_name);
					UI.printInfoMessage("Dane aktualnej osoby zostały wczytane z pliku " + file_name);
				}
					break;
				case 5: {
					// zapis danych aktualnej osoby do pliku tekstowego 
					String file_name = UI.enterString("Podaj nazwę pliku: ");
					Person.printToFile(file_name, currentPerson);
					UI.printInfoMessage("Dane aktualnej osoby zostały zapisane do pliku " + file_name);
				}

					break;
					case 6: {
						//prezetacja ArrayList
						System.out.println("\n Elementy kolekcji ArrayList:");
						wyswietlanieElementowArrayList(peopleArrayList); //wyswietlanie elementow kolekcji
						System.out.println("\n Elementy kolekcji po dodaniu osoby person6:");
						peopleArrayList.add(person6); //dodanie osoby person6
						wyswietlanieElementowArrayList(peopleArrayList); //wyswietlanie elementow kolekcji po dodaniu person6
						peopleArrayList.add(person6); // ponowne dodanie osoby person6
						System.out.println("\n Elementy kolekcji po ponownym dodaniu osoby person6:");
						wyswietlanieElementowArrayList(peopleArrayList); //wyswietlanie elementow kolekcji po ponownym dodaniu person6
						peopleArrayList.remove(person4);
						System.out.println("\n Elementy kolekcji po usunieciu person4:");
						wyswietlanieElementowArrayList(peopleArrayList); //wyswietlanie elementow kolekcji po usunieciu person4
						System.out.println("\n -----------------------");


					}
						break;

					case 7: {
						//prezentacja LinkedList
						System.out.println("\n Elementy kolekcji LinkedList:");
						wyswietlanieElementowLinkedList(peopleLinkedList); //wyswietlanie elementow kolekcji
						System.out.println("\n Elementy kolekcji po dodaniu osoby person6:");
						peopleLinkedList.add(person6); //dodanie osoby person6
						wyswietlanieElementowLinkedList(peopleLinkedList); //wyswietlanie elementow kolekcji po dodaniu person6
						peopleLinkedList.add(person6); // ponowne dodanie osoby person6
						System.out.println("\n Elementy kolekcji po ponownym dodaniu osoby person6:");
						wyswietlanieElementowLinkedList(peopleLinkedList); //wyswietlanie elementow kolekcji po ponownym dodaniu person6
						peopleLinkedList.remove(person3);
						System.out.println("\n Elementy kolekcji po usunieciu person3:");
						wyswietlanieElementowLinkedList(peopleLinkedList); //wyswietlanie elementow kolekcji po usunieciu person3
						System.out.println("\n -----------------------");
					}
					break;

					case 8: {
						//prezentacja HashSet
						System.out.println("\n Elementy kolekcji HashSet:");
						wyswietlanieElementowHashSet(peopleHashSet);
						System.out.println("\n Elementy kolekcji po dodaniu osoby person6:");
						peopleHashSet.add(person6);
						wyswietlanieElementowHashSet(peopleHashSet);
						System.out.println("\n Elementy kolekcji po ponownym dodaniu osoby person6:");
						peopleHashSet.add(person6);
						wyswietlanieElementowHashSet(peopleHashSet);
						System.out.println("\n Elementy kolekcji po usunieciu person1:");
						peopleHashSet.remove(person1);
						wyswietlanieElementowHashSet(peopleHashSet);
						System.out.println("\n -----------------------");
					}
					break;

					case 9: {
						//prezentacja TreeSet
						System.out.println("\n Elementy kolekcji TreeSet:");
						wyswietlanieElementowTreeSet(peopleTreeSet);
						System.out.println("\n Elementy kolekcji po dodaniu osoby person6:");
						peopleTreeSet.add(person6);
						wyswietlanieElementowTreeSet(peopleTreeSet);
						System.out.println("\n Elementy kolekcji po ponownym dodaniu osoby person6:");
						peopleTreeSet.add(person6);
						wyswietlanieElementowTreeSet(peopleTreeSet);
						System.out.println("\n Elementy kolekcji po dodaniu osoby person4:");
						peopleTreeSet.add(person4);
						wyswietlanieElementowTreeSet(peopleTreeSet);
						System.out.println("\n Elementy kolekcji po usunieciu person5:");
						peopleTreeSet.remove(person5);
						wyswietlanieElementowTreeSet(peopleTreeSet);
						System.out.println("\n -----------------------");
					}
					break;

					case 10: {
						//prezenracja HashMap
						System.out.println("\n Elementy kolekcji HashMap:");
						wyswietlanieElementowHashMap(peopleHashMap);
						System.out.println("\n Elementy kolekcji po dodaniu osoby person6:");
						peopleHashMap.put("Szosty", person6);
						wyswietlanieElementowHashMap(peopleHashMap);
						System.out.println("\n Elementy kolekcji po ponownym dodaniu osoby person6:");
						peopleHashMap.put("Siodmy", person6);
						wyswietlanieElementowHashMap(peopleHashMap);
						System.out.println("\n Elementy kolekcji po dodaniu osoby person4:");
						peopleHashMap.put("Osmy", person6);
						wyswietlanieElementowHashMap(peopleHashMap);
						System.out.println("\n Elementy kolekcji po usunieciu person1:");
						peopleHashMap.remove("Pierwszy");
						wyswietlanieElementowHashMap(peopleHashMap);
						System.out.println("\n -----------------------");
					}
					break;

					case 11: {
						//prezentacja TreeMap
						System.out.println("\n Elementy kolekcji TreeMap:");
						wyswietlanieElementowTreeMap(peopleTreeMap);
						System.out.println("\n Elementy kolekcji po dodaniu osoby person6:");
						peopleTreeMap.put("Szesc", person6);
						wyswietlanieElementowTreeMap(peopleTreeMap);
						System.out.println("\n Elementy kolekcji po ponownym dodaniu osoby person6:");
						peopleTreeMap.put("Siedem", person6);
						wyswietlanieElementowTreeMap(peopleTreeMap);
						System.out.println("\n Elementy kolekcji po dodaniu osoby person4:");
						peopleTreeMap.put("Osiem", person4);
						wyswietlanieElementowTreeMap(peopleTreeMap);
						System.out.println("\n Elementy kolekcji po usunieciu person2:");
						peopleHashMap.remove("Dwa");
						wyswietlanieElementowTreeMap(peopleTreeMap);
						System.out.println("\n -----------------------");
					}
					break;

					case 12: {
						//prezentacja HashCode i Equals
						System.out.println("\n Dzialanie metod HashCode oraz Equals \n \nPorownanie person6 i person2 metoda hashCode:");
						System.out.print(person6.hashCode() == person2.hashCode());
						System.out.println("\n Porownanie person6 i person2 metoda Equals:");
						System.out.println(person4.equals(person6));

					}
					break;

				case 0:
					// zakończenie działania programu
					UI.printInfoMessage("\nProgram zakończył działanie!");
					System.exit(0);
				} // koniec instrukcji switch
			} catch (PersonException e) { 
				// Tu są wychwytywane wyjątki zgłaszane przez metody klasy Person,
				// gdy nie są spełnione ograniczenia nałożone na dopuszczalne wartości
				// poszczególnych atrybutów.
				// Drukowanie komunikatu o błędzie zgłoszonym za pomocą wyjątku PersonException.
				UI.printErrorMessage(e.getMessage());
			}
		} // koniec pętli while
	}


	/*
	 *  Metoda wyświetla w oknie konsoli dane aktualnej osoby 
	 *  pamiętanej w zmiennej currentPerson.
	 */
	void showCurrentPerson() {
		showPerson(currentPerson);
	} 

	
	/* 
	 * Metoda wyświetla w oknie konsoli dane osoby reprezentowanej 
	 * przez obiekt klasy Person
	 */ 
	static void showPerson(Person person) {
		StringBuilder sb = new StringBuilder();
		
		if (person != null) {
			sb.append("Aktualna osoba: \n")
			  .append("      Imię: ").append(person.getFirstName()).append("\n")
			  .append("  Nazwisko: ").append(person.getLastName()).append("\n")
			  .append("   Rok ur.: ").append(person.getBirthYear()).append("\n")
			  .append("Stanowisko: ").append(person.getJob()).append("\n");
		} else
			sb.append( "Brak danych osoby\n" );
		UI.printMessage( sb.toString() );
	}

	
	/* 
	 * Metoda wczytuje w konsoli dane nowej osoby, tworzy nowy obiekt
	 * klasy Person i wypełnia atrybuty wczytanymi danymi.
	 * Walidacja poprawności danych odbywa się w konstruktorze i setterach
	 * klasy Person. Jeśli zostaną wykryte niepoprawne dane,
	 * to zostanie zgłoszony wyjątek, który zawiera komunikat o błędzie.
	 */
	static Person createNewPerson(){
		String first_name = UI.enterString("Podaj imię: ");
		String last_name = UI.enterString("Podaj nazwisko: ");
		String birth_year = UI.enterString("Podaj rok ur.: ");
		UI.printMessage("Dozwolone stanowiska:" + Arrays.deepToString(PersonJob.values()));
		String job_name = UI.enterString("Podaj stanowisko: ");
		Person person;
		try { 
			// Utworzenie nowego obiektu klasy Person oraz
			// ustawienie wartości wszystkich atrybutów.
			person = new Person(first_name, last_name);
			person.setBirthYear(birth_year);
			person.setJob(job_name);
		} catch (PersonException e) {    
			// Tu są wychwytywane wyjątki zgłaszane przez metody klasy Person,
			// gdy nie są spełnione ograniczenia nałożone na dopuszczalne wartości
			// poszczególnych atrybutów.
			// Drukowanie komunikatu o błędzie zgłoszonym za pomocą wyjątku PersonException.
			UI.printErrorMessage(e.getMessage());
			return null;
		}
		return person;
	}
	
	
	/* 
	 * Metoda pozwala wczytać nowe dane dla poszczególnych atrybutów 
	 * obiekty person i zmienia je poprzez wywołanie odpowiednich setterów z klasy Person.
	 * Walidacja poprawności wczytanych danych odbywa się w setterach
	 * klasy Person. Jeśli zostaną wykryte niepoprawne dane,
	 * to zostanie zgłoszony wyjątek, który zawiera komunikat o błędzie.
	 */
	static void changePersonData(Person person)
	{
		while (true) {
			UI.clearConsole();
			showPerson(person);

			try {		
				switch (UI.enterInt(CHANGE_MENU + "==>> ")) {
				case 1:
					person.setFirstName(UI.enterString("Podaj imię: "));
					break;
				case 2:
					person.setLastName(UI.enterString("Podaj nazwisko: "));
					break;
				case 3:
					person.setBirthYear(UI.enterString("Podaj rok ur.: "));
					break;
				case 4:
					UI.printMessage("Dozwolone stanowiska:" + Arrays.deepToString(PersonJob.values()));
					person.setJob(UI.enterString("Podaj stanowisko: "));
					break;
				case 0: return;
				}  // koniec instrukcji switch
			} catch (PersonException e) {     
				// Tu są wychwytywane wyjątki zgłaszane przez metody klasy Person,
				// gdy nie są spełnione ograniczenia nałożone na dopuszczalne wartości
				// poszczególnych atrybutów.
				// Drukowanie komunikatu o błędzie zgłoszonym za pomocą wyjątku PersonException.
				UI.printErrorMessage(e.getMessage());
			}
		}
	}
	
	
}  // koniec klasy PersonConsoleApp
