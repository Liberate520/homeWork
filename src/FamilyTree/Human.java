package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private String birthday;
    private Gender gender;
    private Human father;
    private Human mother;
    List<Human> childList = new ArrayList<>();

    public Human(String name, Gender gender, String birthday, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, Gender gender, String birthday){
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
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

    public String info() {
        return name + " " + gender + " " + birthday;
    }
    public String fullInfo(){
        return info()+" father "+father.info()+" mother "+mother.info();
    }

    public void getChild(Human child, Human partner) {
        childList.add(child);
        partner.childList.add(child);
        if (gender == Gender.MALE) {
            child.father = this;
            child.mother = partner;
        } else {
            child.mother = this;
            child.father = partner;
        }
    }
    public void childOf(Human father, Human mother){
        this.father = father;
        this.mother = mother;
        father.childList.add(this);
        mother.childList.add(this);
    }


}

