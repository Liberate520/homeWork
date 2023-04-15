import java.util.ArrayList;
import java.util.List;

public class Person extends Human{
    private Person mother;
    private Person father;
    private Person wife;
    private Person husband;
    private List<Person> brothersOrSistersList;
    private List<Person> childrens;

    public Person(String firstName, String lastName, int age, Sex sex) {
        super(firstName, lastName, age, sex);
        this.brothersOrSistersList = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    public Person() {
        this ("NoName", "NoName", 0, Sex.Male);
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
        output.append(this.printChildrens());
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

    public void addBrotherOrSister(String firstName, String lastName, int age, Sex sex) {
        Person brotherOrSister = new Person(firstName, lastName, age, sex);
        this.brothersOrSistersList.add(brotherOrSister);
    }

    public List<Person> getBrothersOrSistersList() {
        return brothersOrSistersList;
    }

    public void addChildren(String firstName, String lastName, int age, Sex sex) {
        Person child = new Person(firstName, lastName, age, sex);
        this.childrens.add(child);
    }

    public List<Person> getChildrens() {
        return childrens;
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
        if (this.brothersOrSistersList != null && this.brothersOrSistersList.size() != 0) {
            output.append("Brothers and sisters:" + "\n");
            for (Person person: this.brothersOrSistersList) {
                output.append(person.getFirstName() + " " + person.getLastName() + "\n");
            }
        }
        return output.toString();
    }

    public String printChildrens() {
        StringBuilder output = new StringBuilder();
        if (this.childrens != null && this.childrens.size() != 0) {
            output.append("Childrens:" + "\n");
            for (Person child: this.childrens) {
                output.append(child.getFirstName() + " " + child.getLastName() + "\n");
            }
        }
        return output.toString();
    }


}
