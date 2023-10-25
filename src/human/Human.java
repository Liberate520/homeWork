package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Human implements Serializable , Comparable<Human>{
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate born;
    private LocalDate died;
    private Human mother;
    private Human father;
    private List<Human> children;


//    public human.Human(String firstName, String lastName, LocalDate born, LocalDate died, human.Human mother, human.Human father, List<human.Human> children) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.born = born;
//        this.died = died;
//        this.mother = mother;
//        this.father = father;
//        this.children = children;
//    }


    public Human(String firstName, String lastName, Gender gender, LocalDate born, LocalDate died, Human mother, Human father, List<Human> children) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.born = born;
        this.died = died;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }


    public Human(String firstName, String lastName, Gender gender, LocalDate born, LocalDate died, List<Human> children) {
        this(firstName, lastName, gender, born , died, null, null, children);
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate born) {
        this(firstName, lastName, gender, born, null, null);
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate born, LocalDate died) {
        this(firstName, lastName, gender, born, died, null);
    }

    //    @Override
//    public String toString() {
//        return "First name: " + firstName + ", Last name: " + lastName + ", Date of Birth: " + born + ", Date of death: " + died + ", Mother: " + mother.getFirstName() + " " + mother.getLastName() + ", Father" + father.getFirstName() + " " + father.getLastName();
//    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Children:\n");
        if (children != null) {
            for (Human child : children) {
//                stringBuilder.append("\n");
                stringBuilder.append(child.firstName);
                stringBuilder.append(", ");

            }
            return "First name: " + firstName + ", Last name: " + lastName + " Gender " + gender + ", Date of Birth: " + born + ", Date of death: " + died + ", " + stringBuilder.toString();
        }
        return "First name: " + firstName + ", Last name: " + lastName + " Gender " + gender + ", Date of Birth: " + born + ", Date of death: " + died + ".";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public LocalDate getDied() {
        return died;
    }

    public void setDied(LocalDate died) {
        this.died = died;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Children:\n");
        if (children != null) {
            for (Human child : children) {
//                stringBuilder.append("\n");
                stringBuilder.append(child.firstName);
                stringBuilder.append(", ");

            }
            return stringBuilder.toString();
        } else {
            return "not found";
        }
    }


    public void addChildren(List<Human> children) {
        this.children = children;
    }

    public void addChild(Human child) {children.add(child); }

    public int getAge(){
//        LocalDate yearNow = LocalDate.now();
//        LocalDate yearOfBorn = born;
        long years = java.time.temporal.ChronoUnit.YEARS.between(born ,LocalDate.now());
        return (int) years;
    }

    @Override
    public int compareTo(Human o) {
        return this.firstName.compareTo(o.firstName);
    }
}
