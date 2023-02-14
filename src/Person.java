import java.util.ArrayList;
import java.util.List;

class Person {
    private String firstName;
    private String surName;
    private String lastName;
    private String dateOfBirth;
    private String dateOfDeath;
    private List<Person> children;

    public Person(String firstName, String surName, String lastName, String dateOfBirth, String dateOfDeath) {
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getLastName() {
        return lastName;
    }
    /*
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    */
}
