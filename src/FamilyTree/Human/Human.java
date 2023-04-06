package FamilyTree.Human;

import FamilyTree.Writable.FileHandler;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {

    private String name;
    private String birthday;
    private String dateOfDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> childList = new ArrayList<>();

    public Human(String name, Gender gender, String birthday, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, Gender gender, String birthday) {
        this(name, gender, birthday, null, null);

    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildList() {
        return childList;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void addChild(Human partner, Human child) {
        if (gender == Gender.MALE) {
            child.setFather(this);
            child.setMother(partner);
            this.childList.add(child);
            partner.getChildList().add(child);
        }
    }

    public void childOf(Human father, Human mother) {
        setFather(this);
        setMother(this);
        father.childList.add(this);
        mother.childList.add(this);
    }

    public String info() {
        if (dateOfDeath == null) {
            return name + " " + gender +" "+ birthday;
        } else {
            return name + " " + gender +" "+ birthday + "-" + dateOfDeath;
        }
    }
    public void save(String pathName) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(this, pathName);
    }

    public void load(String pathName) throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.load(pathName);
    }
}

