import java.util.*;

public class Person {
    private String myname; //имя
    private char mygender; //пол
    private Person myparent = null; //родитель
    private ArrayList<Person> myChildren; //дети
    
    public Person(String name, char gender, Person parent) {
        myname = name;
        mygender = gender;
        myparent = parent;
        myChildren = new ArrayList<Person>(); 
    }
    public String toString() {
        return myname;
    }

    public String getMyname() {
        return myname;
    }
    public void setMyname(String myname) {
        this.myname = myname;
    }

    public char getMygender() {
        return mygender;
    }
    public void setMygender(char mygender) {
        this.mygender = mygender;
    }
    public Person getMyparent() {
        return myparent;
    }
    public void setMyparent(Person myparent) {
        this.myparent = myparent;
    }
    public ArrayList <Person> getMyChildren() {
        return myChildren;
    }
  
    public void addChild(String childName, char gender) {
        Person child = new Person(childName, gender, this);
        myChildren.add(child);
    }

}
