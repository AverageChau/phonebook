package phonebook;

import java.util.*;

// main program
public class Phonebook {
    // use array to store contacts, index is the phone number for quick access
    // contacts from number
    private final Contact[] contactsArray = new Contact[100000000];

    // use hashmap to store contacts, key is name, value is contacts for quick
    // access contacts from name
    private final Map<String, Contact> contactsHashMap = new HashMap<String, Contact>();

    Scanner scanner = new Scanner(System.in);

    public Phonebook() {
        // print out query guide at the start of the program
        System.out.println("Query List: ");
        System.out.println("\"add NAME NUMBER\" -> add contact name and number, ex: add joe 9166200603");
        System.out.println("\"find NAME\" -> find number using name, ex: find joe");
        System.out.println("\"find NUMBER\" -> find contacts number using name, ex: find 9166200603");
        System.out.println("\"del NUMBER\" -> delete contacts using number, ex: del 9166200603");
        System.out.println("\"del NAME\" -> delete contacts using name, ex: del 9166200603");
        System.out.println("\"print\" -> print all phone book sort by number");
        System.out.println("\"sort\" -> print all phone book sort by name \n");

        // keep asking for query to process
        while (true) {
            processQuery(getQuery());
        }
    }

    // get input from user as string.
    public Query getQuery() {
        System.out.print("Enter query: ");
        return Query.fromString(scanner.nextLine());
    }

    // proccess input to Query class,
    public void processQuery(final Query query) {
        Contact contact;
        switch (query.type) {

            // process add query
            case "add":
                contact = new Contact(query.name, query.number);

                // add contacts to the array using phone number as index
                contactsArray[query.number] = contact;

                // add contacts to the hashmap using name as the key.
                contactsHashMap.put(query.name, contact);
                break;

            // process find query
            case "find":

                // if find + NAME
                if (query.name != null) {
                    contact = contactsHashMap.get(query.name);
                    // see if contact exist.
                    if (contact == null) {
                        System.out.println("not found");
                    } else
                        System.out.println(contact.getNumber());
                }
                // if find + number
                else {
                    contact = contactsArray[query.number];
                    // see if contact exist.
                    if (contact == null) {
                        System.out.println("not found");
                    } else
                        System.out.println(contact.getName());

                }
                break;

            // process del query
            case "del":
                // delete using name
                if (query.name != null) {
                    contact = contactsHashMap.get(query.name);
                }

                // delete using number
                else {
                    contact = contactsArray[query.number];
                }

                contactsArray[contact.getNumber()] = null;
                contactsHashMap.remove(contact.getName());
                break;

            // print phonebook sort by phone number
            case "print":
                System.out.println("******** START OF PHONE BOOK ********");
                for (int i = 0; i < contactsArray.length; i++) {
                    if (contactsArray[i] != null) {
                        System.out.println(contactsArray[i].toString());
                    }
                }
                System.out.println("******** END OF PHONE BOOK ********");
                break;

            // using quicksort, print phone book sort by name
            case "sort":
                // get all the key of hashmap, using Quick Sort to sort this key
                // then print the phone book using sorted key list
                String[] nameList = contactsHashMap.keySet().toArray(new String[0]);
                StringQuickSort.sort(nameList);
                System.out.println("******** START OF PHONE BOOK ********");
                for (int i = 0; i < nameList.length; i++) {
                    System.out.println(contactsHashMap.get(nameList[i]));
                }
                System.out.println("******** END OF PHONE BOOK ********");
                break;
            default:
                System.out.println("query type not found");

        }
        System.out.println();
    }
}