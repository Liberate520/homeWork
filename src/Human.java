import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.SplittableRandom;

public class Human implements Serializable{
    private String sex;
    private String firsName;
    private String lastName;
    private String dateOfBirth;
    private String dateOfDeath;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String dateOfBirth, String dateOfDeath, String sex, String firsName, String lastName, Human mother, Human father, List<Human> children) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Human(String dateOfBirth, String dateOfDeath, String sex, String firstName, String lastName) {
        this(dateOfBirth, dateOfDeath, sex, firstName, lastName, null, null, new ArrayList<>());
    }

    public Human(String sex) {
        this(null, null, sex, "No name", "No family", null, null, new ArrayList<>());
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public String getFullName() {
        return this.firsName + " " + this.lastName + " ";
    }

    public String getChildrenNames() {
        StringBuilder names = new StringBuilder();
        if (children.isEmpty()) {
            return "детей нет";
        }
        for (Human child : this.children) {
            names.append(child.getFullName());
        }
        return names.toString();
    }

    public Human createHuman(String dateOfBirth, String dateOfDeath, String sex, Human mother, String name) {
        Human child = new Human(dateOfBirth, dateOfDeath, sex, name, this.lastName, mother, father, new ArrayList<>());
        this.addChild(child);
        mother.addChild(child);
        return child;
    }

    @Override
    public String toString() {
        return firsName +" " + lastName + ". Дети: " + this.getChildrenNames();
    }
}
