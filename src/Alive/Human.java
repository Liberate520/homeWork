package Alive;

import Alive.enums.Gender;
import Graph.Graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human extends Animal implements Serializable {
    private final int UUIDHuman;
    private static int UUIDHumanCounter = 0;
    protected List<Human> children =new ArrayList<>();
    private Human mother;
    private Human father;
    private List<Human> parentsList=new ArrayList<>();
    public Human(String name, Gender sex, int age, Date born, Date die) {
        super(name, sex, age, born, die);
        UUIDHuman = getNewId();

    }
    public Human(String name, Gender sex, int age, Date born) {
        super(name, sex, age, born);
        UUIDHuman = getNewId();
    }

    public Human(String name, Gender sex, int age, Date born, Date die, Human mother, Human father) {
        super(name, sex, age, born, die);
        this.mother=mother;
        this.father=father;
        mother.addChild(this);
        father.addChild(this);
        UUIDHuman = getNewId();

    }
    public Human(String name, Gender sex, int age, Date born, Human mother, Human father) {
        super(name, sex, age, born);
        this.mother=mother;
        this.father=father;
        mother.addChild(this);
        father.addChild(this);
        UUIDHuman = getNewId();

    }
    public Human(String name, Gender sex, int age, Date born, Human parent) {
        super(name, sex, age, born);
        UUIDHuman = getNewId();
        if (parent.gender==Gender.male){
            father=parent;
            mother=null;
            father.addChild(this);
        }
        else {
            father=null;
            mother=parent;
            mother.addChild(this);
        }
    }
    public Human(String name, Gender sex, int age, Date born, List<Human> parentsList) {
        super(name, sex, age, born);
        this.parentsList=parentsList;
        for (Human human: parentsList
             ) {
            human.addChild(this);

        }
        UUIDHuman = getNewId();
    }
    public void addChild(Human child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            if (this.gender == gender.male) {
                child.father = this;
            } else
                child.mother = this;
        }
    }
    int getNewId(){
        UUIDHumanCounter++;
        return UUIDHumanCounter;

    }
    public List<Human> getChildren() {

        if (!this.children.isEmpty()) {
            return this.children;
        } else

            return null;
    }
    public int getId(){
        return UUIDHuman;
    }
    public List<Human> getParentsList(){
        return parentsList;
    }
    @Override
    public String toString() {
        String res = "Id: "+ getId()+ ", Имя: " + name + ",\t Пол: " + gender + ", Возраст: " + age + ", Дата рождения: " + born;
        if(die!=null){
            res+=", Дата смерти" + die;
        }
        if (!parentsList.isEmpty()){
            res+=", Лист родителей: " +parentsList;
        }
        if (this.mother != null) {
            res += ", Мать: " + mother.name;
        } else
            res += ", Мать: неизвестна";

        if (this.father != null) {
            res += ", Отец: " + father.name + ",";
        } else
            res += ", Отец: неизвестен,";

        if (getChildren()!=null){
            res += getChildren();
        }

        return res;
    }
    public Animal getFather() {
        return father;
    }

    public Animal getMother() {
        return mother;
    }

}