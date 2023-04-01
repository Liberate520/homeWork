import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private boolean isMan;
    private Calendar bornDate;
    private Person married;
    private List<Person> children;
    private List<Person> parents;

    public Person(String firstName, String lastName, boolean isMan) {
        this(firstName, lastName, isMan, new GregorianCalendar());
    }

    public Person(String firstName, String lastName, boolean isMan, Calendar bornDate) {
        this(firstName, lastName, isMan, bornDate, new ArrayList<>(), new ArrayList<>());
    }

    public Person(String firstName, String lastName, boolean isMan, Calendar bornDate, List<Person> children, List<Person> parents) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMan = isMan;
        this.bornDate = bornDate;
        this.children = children;
        this.parents = parents;
    }

    public void addMarried(Person married) {
        this.married = married;
    }

    public Person Married(){
        return this.married;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public int countChildren() {
        return this.children.size();
    }

    public String toString(){
        return this.firstName+" "+this.lastName;
    }
}