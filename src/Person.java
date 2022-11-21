import java.util.*;

public class Person {
    public String myname; //имя
    public char mygender; //пол
    public Person myparent = null; //родитель
    public ArrayList<Person> myChildren; //дети
    
    public Person(String name, char gender, Person parent) {
        myname = name;
        mygender = gender;
        myparent = parent;
        myChildren = new ArrayList<Person>(); 
    }
    public String toString() {
        return myname;
    }
    public void addChild(String childName, char gender) {
        Person child = new Person(childName, gender, this);
        myChildren.add(child);
    }

}
