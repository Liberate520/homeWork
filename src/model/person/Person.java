package model.person;

import model.interfaces.Anthropoid;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

public class Person extends Human implements Serializable, Anthropoid {
    private Anthropoid mother;
    private Anthropoid father;
    private Anthropoid spouse;
    private HashSet<Anthropoid> brothersOrSistersSet;
    private HashSet<Anthropoid> childrenSet;

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

    public void setMother(Anthropoid mother) {
        this.mother = mother;
    }

    public void setFather(String firstName, String lastName, int age) {
        Person father = new Person(firstName, lastName, age, Sex.Male);
        this.father = father;
    }

    public void setFather(Anthropoid father) {
        this.father = father;
    }

    public void setSpouse(String firstName, String lastName, int age, Sex sex) {
        Person spouse = new Person(firstName, lastName, age, sex);
        this.spouse = spouse;
    }

    public void setSpouse(Anthropoid spouse) {
        this.spouse = spouse;
    }

    public Person getMother() {
        return (Person) mother;
    }

    public Person getFather() {
        return (Person) father;
    }

    public Person getSpouse() {
        return (Person) spouse;
    }

    public void addBrother(String firstName, String lastName, int age) {
        Person brother = new Person(firstName, lastName, age, Sex.Male);
        this.brothersOrSistersSet.add(brother);
    }

    public void addBrother(Anthropoid brother) {
        this.brothersOrSistersSet.add(brother);
    }

    public void addSister(String firstName, String lastName, int age) {
        Person sister = new Person(firstName, lastName, age, Sex.Female);
        this.brothersOrSistersSet.add(sister);
    }

    public void addSister(Anthropoid sister) {
        this.brothersOrSistersSet.add(sister);
    }

    public void addBrotherOrSisterSet (HashSet<Anthropoid> brotherOrSisterSet) {
        this.brothersOrSistersSet.addAll(brotherOrSisterSet);
    }

    public void addBrotherOrSisterSet (Anthropoid brotherOrSister) {
        this.brothersOrSistersSet.add(brotherOrSister);
    }

    public HashSet<Anthropoid> getBrothersOrSistersSet() {
        return brothersOrSistersSet;
    }

    public void addChildren(String firstName, String lastName, int age, Sex sex) {
        Person child = new Person(firstName, lastName, age, sex);
        this.childrenSet.add(child);
    }

    public void addChildren(HashSet<Anthropoid> childrenSet) {
        this.childrenSet.addAll(childrenSet);
    }

    public void addChildren(Anthropoid child) {
        this.childrenSet.add(child);
    }

    public HashSet<Anthropoid> getChildrenSet() {
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
            output.append("Братья и сестры: ");
            for (Anthropoid person: this.brothersOrSistersSet) {
                output.append(person.getFirstName() + " " + person.getLastName() + "    ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public String printChildren() {
        StringBuilder output = new StringBuilder();
        if (this.childrenSet != null && this.childrenSet.size() != 0) {
            output.append("Дети: ");
            for (Anthropoid child: this.childrenSet) {
                output.append(child.getFirstName() + " " + child.getLastName() + "    ");
            }
            output.append("\n");
        }
        return output.toString();
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("-----------------------------------------------------------" + "\n");
        output.append(super.toString());
        output.append("Супруг/Супруга: " + this.printPerson((Person) this.spouse) + "\n");
        output.append("Мать: " + this.printPerson((Person) this.mother) + "\n");
        output.append("Отец: " + this.printPerson((Person) this.father) + "\n");
        output.append(this.printBrothersOrSisters());
        output.append(this.printChildren());
        output.append("\n" + "-----------------------------------------------------------");
        return output.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person person) {
            if (person.getFirstName() != null &&
                    person.getLastName() != null) {  // Добавлено условие для избежания ошибки при сериализации
                return this.getFirstName().equals(person.getFirstName()) &&
                        this.getLastName().equals(person.getLastName()) &&
                        this.getAge() == person.getAge();
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getFirstName(), this.getLastName(), this.getAge());
    }


}