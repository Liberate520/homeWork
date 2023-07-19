package ru.gb.family_tree.human;

import ru.gb.family_tree.familytree.TreeItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, TreeItem {
    private LocalDate birthDate ;
    private LocalDate deathDate;
    private Gender gender;

    private List<Human> children;
    private List<Human> parents;
    private int id;
    private String name;

    private int age;



    public Human(String name,LocalDate birthDate, LocalDate deathDate,  Gender gender){
        this.name=name;
        this.birthDate= birthDate;
        this.deathDate=deathDate;
        this.gender=gender;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public Human(String name, LocalDate birthDate, Gender gender ){

        this( name, birthDate, null, gender);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List addChild(Human child) {
        if (!children.contains(child)) children.add(child);
        return children;
    }

    public List addParent(Human parent) {

        if (!parents.contains(parent)) parents.add(parent);
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public Object getSpouse() {
        return null;
    }

    @Override
    public void setSpouse(Object human) {

    }


    public Gender getGender() {
        return gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }


    public String getFatherInfo() {
        StringBuilder st = new StringBuilder();
        st.append("Father: ");
        Human father=getFather();
        if (father!=null){
            st.append(father.getName());
        }
        else{st.append("unknown");}

        return st.toString();
    }
    public String getMotherInfo() {
        StringBuilder st = new StringBuilder();
        st.append("Mother: ");
        Human mother=getMother();
        if (mother!=null){
            st.append(mother.getName());
        }
        else{st.append("unknown");}

        return st.toString();
    }

    public String getChildrenInfo() {
        StringBuilder st = new StringBuilder();
        st.append("Children: ");
        if (children.size() != 0) {
            st.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                st.append(", ");
                st.append(children.get(i).getName());
            }
        }
        else st.append("null");
        return st.toString();
    }
    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender()==Gender.Male)
            return parent;
        }
        return null;
    }
    public Human getMother(){
        for (Human parent: parents){
            if (parent.getGender()==Gender.Female)
                return parent;
        }
        return null;
    }

    @Override
    public Boolean addChild(Object human) {
        return null;
    }

    @Override
    public Boolean addParent(Object human) {
        return null;
    }

    public List<Human> getParents() {
        return parents;
    }

    public int  getAge() {
        if (deathDate ==null){
            LocalDate currentDate=LocalDate.now();
            return Period.between(birthDate, currentDate).getYears();
        }
        else {
            return Period.between(birthDate, deathDate).getYears();
        }

    }

    @Override
    public String toString() {
        return getInfo();
    }

    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
    public String getInfo(){
        StringBuilder sb=new StringBuilder();
        sb.append("ID: ");
        sb.append(getId());
        sb.append(" ,Имя: ");
        sb.append(getName());
        sb.append(",  ");
        sb.append(getAge());
        sb.append(",  ");
        sb.append(getFatherInfo());
        sb.append(",  ");
        sb.append(getMotherInfo());
        sb.append(",  ");
        sb.append(getChildrenInfo());

        return sb.toString();
    }



}
