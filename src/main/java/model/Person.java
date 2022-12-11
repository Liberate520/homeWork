package model;
import java.util.*;
public class Person implements Iterable<Person>{
    private String myName; //имя
    private Person myParent = null; //родитель
    private ArrayList<Person> myChildren; //дети
    
    public Person(String name, Person parent) {
        myName = name;
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
    public Person getMyparent() {
        return myParent;
    }
    public void setMyparent(Person myparent) {
        this.myParent = myparent;
    }
    public ArrayList <Person> getMyChildren() {
        return myChildren;
    }
  
    public void addChild(String childName) {
        Person child = new Person(childName, this);
        myChildren.add(child);
    }
    @Override
    public Iterator<Person> iterator() {
        return myChildren.iterator();
        }
}
