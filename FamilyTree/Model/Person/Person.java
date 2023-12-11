package FamilyTree.FamilyTree.Model.Person;

import FamilyTree.FamilyTree.Model.Tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;


public class Person implements Serializable, TreeItem<Person> {

    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person father, mother;

    private Person spouse;
    private ArrayList<Person> children = new ArrayList<Person>();

    private Gender gender;

    public Person(String name, Gender gender, String date) {
        this.name = name;
        this.gender = gender;
        this.birthDate = LocalDate.parse(date);
        this.deathDate = LocalDate.parse(date);
    }

    @Override
    public int setId(int humansId) {
        return 0;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Gender getGender() {
        return null;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Override
    public LocalDate getDeathDate() {
        return this.deathDate;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void addParent(Person parent) {
        if (parent.gender.equals(Gender.Male)) {
            this.setFather(parent);
            if (!parent.getChildren().contains(this)) {
                parent.addChild(this);
            }
        } else {
            this.setMother(parent);
            if (!parent.getChildren().contains(this)) {
                parent.addChild(this);
            }
        }
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    @Override
    public List<Person> getParents() {
        return null;
    }


    public void addSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse() {
        return spouse;
    }


    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("name: ").append(name).append("\n")
                .append("gender: ").append(gender).append("\n")
                .append("date of birth: ").append(birthDate).append("\n");

        if (deathDate != null) {
            tmp.append("date of death: ").append(deathDate).append("\n");
        } else {
            tmp.append("--").append("\n");
        }

        tmp.append("parents: ");
        if (father != null) {
            tmp.append(father.name).append(", ");
        } else {
            tmp.append("--").append(", ");
        }

        if (mother != null) {
            tmp.append(mother.name).append("\n");
        } else {
            tmp.append("--").append("\n");
        }

        tmp.append("spouse: ");
        if (spouse != null) {
            tmp.append(spouse.name).append("\n");
        } else {
            tmp.append("--").append("\n");
        }

        tmp.append("children: ");
        for (Person child : children) {
            tmp.append(child.name).append(" ");
        }
        tmp.append("\n");

        return tmp.toString();
    }
}




