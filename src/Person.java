import java.util.HashSet;
import java.util.Objects;

public class Person extends Human{
    private Person mother;
    private Person father;
    private Person wife;
    private Person husband;
    private HashSet<Person> brothersOrSistersSet;
    private HashSet<Person> childrenSet;

    public Person(String firstName, String lastName, int age, Sex sex) {
        super(firstName, lastName, age, sex);
        this.brothersOrSistersSet = new HashSet<>();
        this.childrenSet = new HashSet<>();
    }

    public Person() {
        this ("NoName", "NoName", 0, Sex.Male);
    }

    public void setMother(String firstName, String lastName, int age) {
        Person mother = new Person(firstName, lastName, age, Sex.Female);
        this.mother = mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(String firstName, String lastName, int age) {
        Person father = new Person(firstName, lastName, age, Sex.Male);
        this.father = father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setWife(String firstName, String lastName, int age) {
        Person wife = new Person(firstName, lastName, age, Sex.Female);
        this.wife = wife;
    }

    public void setWife(Person wife) {
        this.wife = wife;
    }

    public void setHusband(String firstName, String lastName, int age) {
        Person husband = new Person(firstName, lastName, age, Sex.Male);
        this.husband = husband;
    }

    public void setHusband(Person husband) {
        this.husband = husband;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Person getWife() {
        return wife;
    }

    public Person getHusband() {
        return husband;
    }

    public void addBrother(String firstName, String lastName, int age) {
        Person brother = new Person(firstName, lastName, age, Sex.Male);
        this.brothersOrSistersSet.add(brother);
    }

    public void addBrother(Person brother) {
        this.brothersOrSistersSet.add(brother);
    }

    public void addSister(String firstName, String lastName, int age) {
        Person sister = new Person(firstName, lastName, age, Sex.Female);
        this.brothersOrSistersSet.add(sister);
    }

    public void addSister(Person sister) {
        this.brothersOrSistersSet.add(sister);
    }

    public void addBrotherOrSisterSet (HashSet<Person> brotherOrSisterSet) {
        this.brothersOrSistersSet.addAll(brotherOrSisterSet);
    }

    public void addBrotherOrSisterSet (Person brotherOrSister) {
        this.brothersOrSistersSet.add(brotherOrSister);
    }

    public HashSet<Person> getBrothersOrSistersSet() {
        return brothersOrSistersSet;
    }

    public void addChildren(String firstName, String lastName, int age, Sex sex) {
        Person child = new Person(firstName, lastName, age, sex);
        this.childrenSet.add(child);
    }

    public void addChildren(HashSet<Person> childrenSet) {
        this.childrenSet.addAll(childrenSet);
    }

    public void addChildren(Person child) {
        this.childrenSet.add(child);
    }

    public HashSet<Person> getChildrenSet() {
        return childrenSet;
    }

    public String printPerson(Person person) {
        StringBuilder output = new StringBuilder();
        if (person != null) {
            output.append(person.getFirstName() + " " + person.getLastName());
        }
        return output.toString();
    }

    public String printBrothersOrSisters() {
        StringBuilder output = new StringBuilder();
        if (this.brothersOrSistersSet != null && this.brothersOrSistersSet.size() != 0) {
            output.append("Brothers and sisters:" + "\n");
            for (Person person: this.brothersOrSistersSet) {
                output.append(person.getFirstName() + " " + person.getLastName() + "\n");
            }
        }
        return output.toString();
    }

    public String printChildren() {
        StringBuilder output = new StringBuilder();
        if (this.childrenSet != null && this.childrenSet.size() != 0) {
            output.append("Children:" + "\n");
            for (Person child: this.childrenSet) {
                output.append(child.getFirstName() + " " + child.getLastName() + "\n");
            }
        }
        return output.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        output.append("Wife: " + this.printPerson(this.wife) + "\n");
        output.append("Husband: " + this.printPerson(this.husband) + "\n");
        output.append("Mother: " + this.printPerson(this.mother) + "\n");
        output.append("Father: " + this.printPerson(this.father) + "\n");
        output.append(this.printBrothersOrSisters());
        output.append(this.printChildren());
        return output.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person person) {
            return this.getFirstName().equals(person.getFirstName()) &&
                    this.getLastName().equals(person.getLastName()) &&
                    this.getAge() == person.getAge();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getFirstName(), this.getLastName(), this.getAge());
    }
}