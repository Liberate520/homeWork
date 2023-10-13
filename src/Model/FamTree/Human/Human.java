package Model.FamTree.Human;

import Model.FamTree.TreeMembers;

import java.io.Serializable;
import java.util.*;

public class Human implements Serializable, Comparable<Human>, TreeMembers {
    private long id;
    private String firstName;
    private String lastName;
    private Gender sex;
    private int age;
    private Human father;
    private Human mother;
    private Set<Human> children;
    private Human marriagePartner;

    public Human(int id, String firstName, String lastName, Gender sex, int age) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }
    public Human() {
        children = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public Gender getSex() {
        return sex;
    }
    public boolean isMan() {
        return (sex== Gender.M);
    }
    public boolean isWom() {
        return (sex== Gender.W);
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Human getFather() {
        return father;
    }


    public void setFather(Human father) {
        this.father = father;
        father.addChildrenWithoutSettingParents(this);
    }
    private void addChildrenWithoutSettingParents(Human children) {
         {
            this.children.add(children);
        }
    }
    public Human getMother() {
        return mother;
    }

    @Override
    public void setFather(Object father) {

    }

    public void setMother(Human mother) {
        this.mother = mother;
        mother.addChildrenWithoutSettingParents(this);
    }
    public List<Human> getChildren() {
        List<Human> childrenList = new ArrayList<>();
        childrenList.addAll(children);
        return childrenList;
    }
    public void setChildren(List<Human> children) {
        this.children = new HashSet<>(children);
    }
    private void setFatherWithoutAddingChild(Human father) {
        this.father = father;
    }
    private void setMotherWithoutAddingChild(Human mother) {
        this.mother = mother;
    }
    public void addChildren(Human... children) {
        for (Human child : children) {
            if (isMan()) {
                child.setFatherWithoutAddingChild(this);
            } else {
                child.setMotherWithoutAddingChild(this);
            }
            this.children.add(child);
        }
    }

    public Human getMarriagePartner() {
        return marriagePartner;
    }
    public boolean setMarriagePartner(Human marriagePartner) {
        if (isMan() != marriagePartner.isMan()) {
            this.marriagePartner = marriagePartner;
            marriagePartner.marriagePartner = this;
            if (isWom()) {
                setLastName(marriagePartner.getLastName());
            }
            else {
                marriagePartner.setLastName(lastName);
            }
            return true;
        }
        return false;
    }
    public String getChildrenInf(){
        StringBuilder res = new StringBuilder();
        res.append(" Childrens: ");
        if (!children.isEmpty()) {
            for (Human child : children
            ) {
                res.append(child.getFirstName());
                res.append(" | ");
            }
        }
        else {
            res.append("No");
            }
        return res.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(" Name: ");
        sb.append(firstName);
        sb.append(" Famil: ");
        sb.append(lastName);
        sb.append("Age: ");
        sb.append(age);
        sb.append(" Father: ");
        if (father!= null) {

            sb.append(getFather().firstName);
        }
        else {
            sb.append(" n/a");
        }
        sb.append(" Mother: ");
        if (mother!= null) {

            sb.append(getMother().firstName);
        }
        else {
            sb.append(" n/a");
        }
        sb.append(" Partner: ");
        if (marriagePartner!= null) {

            sb.append(getMarriagePartner().firstName);
        }
        else {
            sb.append(" n/a");
        }
        sb.append(getChildrenInf());
        return sb.toString();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return getId() == human.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    @Override
    public int compareTo(Human o) {
        long l = id - (long) o.getId();
        return (int) l;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void addChildren(Object[] children) {

    }
}
