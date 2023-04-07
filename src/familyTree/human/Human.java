package familyTree.human;

import familyTree.writable.FileHandler;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Human implements Serializable {

    private String name;
    private Calendar birthday;
    private Calendar dateOfDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> childList = new ArrayList<>();

    public Human(String name, Gender gender, Calendar birthday, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, Gender gender, Calendar birthday) {
        this(name, gender, birthday, null, null);

    }

    public String getName() {
        return name;
    }

    public Calendar getBirthday() {
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

    public Calendar getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Calendar dateOfDeath) {
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
            return name + " " + gender +" "+ datePrint(birthday);
        } else {
            return name + " " + gender +" "+ datePrint(birthday) + "-" + datePrint(dateOfDeath);
        }
    }
    public String datePrint(Calendar calendar){
        return birthday.get(Calendar.DAY_OF_MONTH)+"."+birthday.get(Calendar.MONTH)+"."+birthday.get(Calendar.YEAR);
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

