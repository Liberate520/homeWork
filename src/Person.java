import java.util.ArrayList;
import java.util.List;

public class Person {
    protected List<Person> children = new ArrayList<>();

    static protected List<Person> persons;
    protected Person parent = null;
    protected String firstName = null;
    protected String secondName = null;

    static {
        persons = new ArrayList<>();
    }

    public Person(String secondName, String firstName){
        this.secondName = secondName;
        this.firstName = firstName;
        this.addPerson(this);
    }

    public Person(String secondName, String firstName, Person parent){
        this.secondName = secondName;
        this.firstName = firstName;
        this.parent = parent;
        parent.addChild(this);
        this.addPerson(this);
    }

    public void addPerson(Person person){
        persons.add(person);
    }

    public static List<Person> getPersons(){
        return persons;
    }

    public List<Person> getChildren(){
        return children;
    }

    public void setParent(Person parent){
        this.parent = parent;
        parent.addChild(this);
    }

    public Person getParent(){
        return this.parent;
    }

    public void addChild(Person child){
        //child.setParent(this);
        this.children.add(child);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getSecondName(){
        return this.secondName;
    }

    public void setFirstName(String firstName){
        this.secondName = firstName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    @Override
    public String toString(){
        return (firstName + " " + secondName);
    }
}