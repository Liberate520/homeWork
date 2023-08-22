package home_work.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, AnimalItem {
    private String name;
    private List<Human> childrens = new ArrayList<>();
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private List<Human> parents = new ArrayList<>();
    private List<String> childrensName = new ArrayList<>();
    private List<String> parentsName = new ArrayList<>();

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth) {
        this(name, gender, dateOfBirth, null);
    }

    

    public void addChildren(Human children) {
        this.childrens.add(children);
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public List<String> getChildrensName() {
        for (Human human : childrens) {
            if (!childrensName.contains(human.name)) {
                childrensName.add(human.name);
            }
        }
        return childrensName;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<String> getParentsName() {
        for (Human human : parents) {
            parentsName.add(human.name);
        }
        return parentsName;
    }

    @Override
    public String toString() {
        if (dateOfDeath != null) {
            return "Name: " + name + " gender: " + gender + " data of birth: " + dateOfBirth +
                                            " date of death: " + dateOfDeath;
        } 
        else {
            return "Name: " + name + " gender: " + gender + " data of birth: " + dateOfBirth;
        }
    }
}
