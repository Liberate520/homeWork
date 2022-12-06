import java.util.*;

public class Person {
    private String myName; //имя
    private String myGender; //пол
    private Person myParent = null; //родитель
    private ArrayList<Person> myChildren; //дети
    
    public Person(String name, String gender, Person parent) {
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

    public String getMygender() {
        return myGender;
    }
    public void setMygender(String mygender) {
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
  
    public void addChild(String childName, String gender) {
        Person child = new Person(childName, gender, this);
        myChildren.add(child);
    }

}
