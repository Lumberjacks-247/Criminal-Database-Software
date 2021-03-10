package CriminalDatabaseSoftware;

public class Person {

    private String firstName, lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public static void main(String[] args) {
        Person dylan = new Suspect("Dylan", "Neff");
        System.out.println(dylan.getName());
    }
    
}
