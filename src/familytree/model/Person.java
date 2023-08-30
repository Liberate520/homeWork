package familytree.model;

import familytree.Gender;

import java.util.ArrayList;
import java.util.List;

public class Person extends TreeEntity{
    private String name;
    private Gender gender;
    private String dateOfBirth; //dob
    private String dateOfDeath; //dod
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, Gender gender, String dob) {
        super(name, dob);
        this.gender = gender;
    }
    public Person(String name, Gender gender, String dateOfBirth, String dateOfDeath) {
        super(name, dateOfBirth);
        this.gender = gender;
        this.dateOfDeath = dateOfDeath;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child){
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDayOfBirth() {
        return dateOfBirth;
    }

    public List<Person> getChildren() {
        return children;
    }
    public  String toString(){
        return "Name: " + getName() + ", Gender: " + gender + ", DOB: " + getDOB();
    }
}
