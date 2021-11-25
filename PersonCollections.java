package tb.soft;
import com.sun.source.tree.Tree;

import java.util.*;

public class PersonCollections extends Person{
    public PersonCollections(String first_name, String last_name) throws PersonException {
        super(first_name, last_name);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    static PersonCollections person1;
    static {
        try {
            person1 = new PersonCollections("George", "Garcia");
        } catch (PersonException e) {
            e.printStackTrace();
        }
    }

    static PersonCollections person2;
    static {
        try {
            person2 = new PersonCollections("David", "Martinez");
        } catch (PersonException e) {
            e.printStackTrace();
        }
    }

    static PersonCollections person3;
    static {
        try {
            person3 = new PersonCollections("Mary", "Taylor");
        } catch (PersonException e) {
            e.printStackTrace();
        }
    }

    static PersonCollections person4;
    static {
        try {
            person4 = new PersonCollections("Charles", "Martinez");
        } catch (PersonException e) {
            e.printStackTrace();
        }
    }

    static PersonCollections person5;
    static {
        try {
            person5 = new PersonCollections("Barbara", "Jackson");
        } catch (PersonException e) {
            e.printStackTrace();
        }
    }

    static PersonCollections person6;
    static {
        try {
            person6 = new PersonCollections("David", "Martinez");
        } catch (PersonException e) {
            e.printStackTrace();
        }
    }


    //Metody wyswietlajace osoby

    public static void wyswietlanieElementowLinkedList(LinkedList<PersonCollections> peopleLinkedList){
        int i=0;
        for(PersonCollections personCollections: peopleLinkedList){
            System.out.println(i + "." + personCollections.getFirstName() + " " + personCollections.getLastName());
            i++;
        }
    }

    public static void wyswietlanieElementowArrayList(ArrayList<PersonCollections> peopleArrayList){
        int i=0;
        for(PersonCollections personCollections: peopleArrayList){
            System.out.println(i + "." + personCollections.getFirstName() + " " + personCollections.getLastName());
            i++;
        }
    }

    public static void wyswietlanieElementowHashSet(HashSet<PersonCollections> peopleHashSet){
        int i=0;
        for(PersonCollections personCollections: peopleHashSet){
            System.out.println(i + "." + personCollections.getFirstName() + " " + personCollections.getLastName());
            i++;
        }
    }

    public static void wyswietlanieElementowTreeSet(TreeSet<PersonCollections> peopleTreeSet){
        int i=0;
        for(PersonCollections personCollections: peopleTreeSet){
            System.out.println(i + "." + personCollections.getFirstName() + " " + personCollections.getLastName());
            i++;
        }
    }

    public static void wyswietlanieElementowHashMap(HashMap<String, PersonCollections> peopleHashMap){
        int i=0;
        for(String key : peopleHashMap.keySet()){
           PersonCollections personCollections = peopleHashMap.get(key);
            //System.out.println(i + ".Klucz: " + personCollections);
            System.out.println(personCollections.getFirstName() + " " + personCollections.getLastName());
            i++;
        }
    }

    public static void wyswietlanieElementowTreeMap(TreeMap<String,PersonCollections> peopleTreeMap) {
        int i = 0;
        for (String key : peopleTreeMap.keySet()) {
            PersonCollections person = peopleTreeMap.get(key);
            //System.out.println(i + ".Klucz: " + person.getLastName());
            System.out.println(person.getFirstName() + " " + person.getLastName());
            i++;
        }
    }

    }

