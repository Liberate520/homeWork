package HW.dog;

import HW.human.enumerate.Sex;
import HW.member.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dog implements Serializable, Member {

    private String name;
    private String surname;
    private Sex sex;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Dog father;
    private Dog mother;
    private List<Member> children;

    public Dog(String name, String surname, Sex sex, LocalDate dateOfBirth) {
        this(name, surname, sex, dateOfBirth, null, null, null, new ArrayList<>());
    }

    public Dog(String name, String surname, Sex sex, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this(name, surname, sex, dateOfBirth, dateOfDeath, null, null, new ArrayList<>());
    }

    public Dog(String name, String surname, Sex sex, LocalDate dateOfBirth, Dog father, Dog mother) {
        this(name, surname, sex, dateOfBirth, null, father, mother, new ArrayList<>());
    }

    public Dog(String name, String surname, Sex sex, LocalDate dateOfBirth, LocalDate dateOfDeath, Dog father, Dog mother, List<Member> children) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    public Dog getFather() {
        return father;
    }

    public Dog getMother() {
        return mother;
    }

    public List<Member> getChildren() {
        return children;
    }

    @Override
    public void setChildren(Member human) {this.children.add(human);}

    public void setChildren(Dog dog) {
        this.children.add(dog);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                ", father=" + ((father != null) ? father.getName() : "Unknown") +
                ", mother=" + ((mother != null) ? mother.getName() : "Unknown") +
                ", children=" + showChild() +
                '}';
    }

    private String showChild() {
        StringBuilder childResult = new StringBuilder();
        for (Member dog : children) {
            childResult.append(dog.getName() + " " + dog.getSurname() + " ");
        }
        return childResult.toString();
    }
}

