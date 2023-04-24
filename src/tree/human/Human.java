package tree.human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>{
    private Gender gender;
    private Human husband;
    private String name;
    private Integer age;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(Gender gender, String name, Integer age, Human mother, Human father, Human husband){
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.mother = mother;
        this.father = father;
        this.husband = husband;
        this.children = new ArrayList<>();
    }

    public Human(Gender gender, String name, Integer age, Human mother, Human father){
        this(gender, name, age, mother, father, null);
    }

    public Human(Gender gender, String name, Integer age){
        this(gender, name, age, null, null);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getHusband() {
        return husband;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFather(Human father) {
        this.father = father;
        // if (!father.getChildren().contains(this.getName())) father.addChild(this);
    }

    public void setMother(Human mother) {
        this.mother = mother;
        // if (!mother.getChildren().contains(this.getName())) mother.addChild(this);
    }

    public void addHusband(Human husband){
        this.husband = husband;
        if (husband.getHusband() == null) husband.addHusband(this);
    }

    public void addChild(Human child) {
        if(!children.contains(child)){
            children.add(child);
            if (this.getGender() == Gender.Male) {
                if (child.getFather() != this) child.setFather(this);
            }
            else{
                if(child.getMother() == null) child.setMother(this);
            }
        }
    }

    public List<Human> getParents() {
        List<Human> res = new ArrayList<>();
        if (father != null) res.add(father);
        if (mother != null) res.add(mother);
        return res;
    }

    public String getParentsNames() {
        String f = "";
        String m = "";
        if (father != null) f = father.getName();
        if (mother != null) m = mother.getName();
        return f + " " + m;
    }

    public List<Human> getGrandParents() {
        List<Human> res = new ArrayList<>();
        if (father != null) res.addAll(father.getParents());
        if (mother != null) res.addAll(mother.getParents());
        return res;
    }

    public String getGrandParentsNames() {
        String gf = "";
        String gm = "";
        if (father != null) gf = father.getParentsNames();
        if (mother != null) gm = mother.getParentsNames();
        return gf + " " + gm;
    }

    public List<Human> getChildren() {
        List<Human> res = new ArrayList<>();
        for (Human human : children) {
            res.add(human);
        }
        return res;
    }

    public List<String> getChildrenNames() {
        List<String> res = new ArrayList<>();
        for (Human human : children) {
            res.add(human.getName());
        }
        return res;
    }

    public List<Human> getBrothersAndSisters() {
        List<Human> res = new ArrayList<>();
        if (father.getChildren() != null) res = father.getChildren();
        else if (mother.getChildren() != null) res = mother.getChildren();
        res.remove(this);
        return res;
    }

    public List<String> getBrothersAndSistersNames() {
        List<String> res = new ArrayList<>();
        if (father.getChildren() != null) res = father.getChildrenNames();
        else if (mother.getChildren() != null) res = mother.getChildrenNames();
        return res;
    }

    @Override
    public String toString() {
        String m = "";
        String f = "";
        String h = "";
        List<String> c = new ArrayList<>();
        if (mother != null) m = mother.getName();
        if (father != null) f = father.getName();
        if (husband != null) h = husband.getName();
        if (children != null) c = this.getChildrenNames();
        return "Имя: " + name + "\nВозраст: " + age + "\nпол: " + gender + "\nМать: " + m + "\nОтец: " + f + "\nСупруг/супруга: " + h +"\nДети: " + c + "\n";
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
