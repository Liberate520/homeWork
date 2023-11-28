package fam_tree.human;

import fam_tree.family_tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, Comparable<Human>, TreeItem<Human> {
    private int id;
    private final String name;
    private final Gender gender;
    private final LocalDate birthDay;
    private final LocalDate deathDay;
    private Human mother;
    private Human father;
    private final List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDay,
                 Human mother, Human father) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }


    public Human(String name, Gender gender, LocalDate birthDay) {
        this(name,gender,birthDay,null,null,null);
    }

    public Human(String name, Gender gender, LocalDate birthDay, Human mother, Human father) {
        this(name,gender,birthDay,null,mother,father);
    }

    public void addChildren(Human human) {
        if (!children.contains(human)) {
            children.add(human);
        }
    }

    @Override
    public void setSpouse(Human human) {

    }

    public void addParent(Human human) {
        if (human.getGender().equals(Gender.Male)) {
            setFather(human);
        } else if (human.getGender().equals(Gender.Female)) {
            setMather(human);
        }
    }

    public void setMather(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getParrent() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public void addParents(Human human) {

    }

    public Gender getGender() {
        return gender;
    }
    public int getAge(){
        return getPeriod(birthDay, Objects.requireNonNullElseGet(deathDay, LocalDate::now));
    }

    private int getPeriod(LocalDate birthDay, LocalDate deathDay) {
        Period res = Period.between(birthDay,deathDay);
        return res.getYears();
    }

    public int getId() {
        return id;
    }

    @Override
    public List<Human> getParents() {
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public Human getSpouse() {
        return null;
    }

    @Override
    public LocalDate getBirthDay() {
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(name);
        sb.append(", id: ");
        sb.append(id);
        sb.append(", Age: ");
        sb.append(getAge());
        sb.append(", Mother: ");
        sb.append(getMotherInfo());
        sb.append(", Father: ");
        sb.append(getFatherInfo());
        sb.append(", Children: ");
        sb.append(getChildrenInfo());

        return sb.toString();
    }

    public String getMotherInfo() {
        String res = "";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "";
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        if (!children.isEmpty()) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else {
            sb.append("нет");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human human)) {
            return false;
        }
        return human.getId() == getId();
    }

    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
