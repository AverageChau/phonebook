// Contact.java
// Contact class that include name as String and number as integer.

package phonebook;

public class Contact {
    private String name;
    private int number;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("-Name: %s, number: %d-", this.name, this.number);
    }

}