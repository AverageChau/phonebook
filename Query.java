// Query.java
// turn user input into query for phone book
// 

package phonebook;

public class Query {
    public String type; // find, add, delete, sort, print
    public String name; // contact name,
    public int number; // phone number

    private Query(String type, String name, int number) {
        this.type = type;
        this.name = name;
        this.number = number;
    }

    private Query(String type, int number) {
        this.type = type;
        this.number = number;
    }

    private Query(String type, String name) {
        this.type = type;
        this.name = name;
    }

    private Query(String type) {
        this.type = type;
    }

    static public Query fromString(String input) {
        String[] inputAray = input.split("\\s+"); // split by space or ' ', "one two three" split into ["one", "two",
                                                  // "three"]

        // print and sort query
        if (inputAray.length == 1) {
            return new Query(inputAray[0]);
        }

        // find and add query
        else if (inputAray.length == 2) {
            try {
                int number = Integer.parseInt(inputAray[1]);
                return new Query(inputAray[0], number);
            } catch (Exception e) {
                return new Query(inputAray[0], inputAray[1]);
            }
        }

        // add query
        else if (inputAray.length == 3) {
            return new Query(inputAray[0], inputAray[1], Integer.parseInt(inputAray[2]));
        }

        // invalids
        throw new RuntimeException("Invalid query");
    }

}