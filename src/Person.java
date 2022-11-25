import java.util.*;

public class Person {
    private String myName; //имя
    private char myGender; //пол
    private Person myParent = null; //родитель
    private ArrayList<Person> myChildren; //дети
    
    public Person(String name, char gender, Person parent) {
        myName = name;
        myGender = gender;
        myParent = parent;
        myChildren = new ArrayList<Person>(); 
    }
    public String toString() {
        return myName;
    }

    public String getMyname() {
        return myName;
    }
    public void setMyname(String myname) {
        this.myName = myname;
    }

    public char getMygender() {
        return myGender;
    }
    public void setMygender(char mygender) {
        this.myGender = mygender;
    }
    public Person getMyparent() {
        return myParent;
    }
    public void setMyparent(Person myparent) {
        this.myParent = myparent;
    }
    public ArrayList <Person> getMyChildren() {
        return myChildren;
    }
  
    public void addChild(String childName, char gender) {
        Person child = new Person(childName, gender, this);
        myChildren.add(child);
    }

}
