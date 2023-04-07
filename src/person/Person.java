package person;

import java.io.Serializable;
import java.util.*;

public class Person implements Serializable, Comparable<Person> {
    private String fullName;
    private final Calendar dateOfBirth;
    private Calendar dateOfDeath;
    private Gender gender;
    private Person mother;
    private Person father;
    private HashSet<Person> children;

    public Person(String fullName, Calendar dateOfBirth, Calendar dateOfDeath, Gender gender, Person mother, Person father, HashSet<Person> children) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }
    public Person(String fullName, Calendar dateOfBirth, Calendar dateOfDeath, Gender gender, Person mother, Person father) {
        this(fullName, dateOfBirth, dateOfDeath, gender, mother, father, new HashSet<>());
    }
    public Person(String fullName, Calendar dateOfBirth, Calendar dateOfDeath, Gender gender, HashSet<Person> children) {
        this(fullName, dateOfBirth, dateOfDeath, gender, null, null, children);
    }
    public Person(String fullName, Calendar dateOfBirth, Calendar dateOfDeath, Gender gender) {
        this(fullName, dateOfBirth, dateOfDeath, gender, null, null, new HashSet<>());
    }
    public Person(String fullName, Calendar dateOfBirth, Gender gender, Person mother, Person father) {
        this(fullName, dateOfBirth, null, gender, mother, father, new HashSet<>());
    }
    public Person(String fullName, Calendar dateOfBirth, Gender gender, HashSet<Person> children) {
        this(fullName, dateOfBirth, null, gender, children);
    }
    public Person(String fullName, Calendar dateOfBirth, Gender gender) {
        this(fullName, dateOfBirth, null, gender, null, null, new HashSet<>());
    }
    public boolean addChild(Person child) {
        if (child!=null){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        Calendar currentDate = new GregorianCalendar();
        return currentDate.get(Calendar.YEAR) - this.getDateOfBirth().get(Calendar.YEAR);
    }

    public Gender getGender() {
        return gender;
    }

    public Calendar getDateOfDeath() {
        return dateOfDeath;
    }

    public Person getMother() {
        return mother;
    }


    public Person getFather() {
        return father;
    }
    public StringBuilder getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full Name: ");
        sb.append(fullName);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb;
    }
    public StringBuilder getMotherInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Mother: ");
        if (mother!=null){
            res.append(mother.getFullName());
        } else {
            res.append("unknown");
        }
        return res;
    }
    public StringBuilder getFatherInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Father: ");
        if (father!=null){
            res.append(father.getFullName());
        } else {
            res.append("unknown");
        }
        return res;
    }
    public StringBuilder getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Children: ");
        if (!children.isEmpty()){
            for (Person child:children) {
                res.append(child.getFullName());
            }
        } else {
            res.append("unknown");
        }
        return res;
    }

    public HashSet<Person> getChildren() {
        return children;
    }

    public void setDateOfDeath(Calendar dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setChildren(HashSet<Person> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Full name: " + getFullName();
    }
    @Override
    public int compareTo(Person p) {
        return getFullName().compareTo(p.getFullName());
    }
}