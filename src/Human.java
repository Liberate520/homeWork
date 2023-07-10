package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    LocalDate birthDate ;
    LocalDate deathDate;
    Gender gender;
    Human father,mother;
    private List<Human> children;
    private List<Human> parents;
    private int id;
    private String name;

    public Human(String name,LocalDate birthDate, LocalDate deathDate,  Gender gender, List parents){
        this.name=name;
        this.birthDate= birthDate;
        this.deathDate=deathDate;
        this.gender=gender;

        this.parents =new ArrayList<>();

        this.children=new ArrayList<>();
    }
    public Human(String name,LocalDate birthDate,  Gender gender, List parents ){
        this( name, birthDate, null, gender, parents);
    }
    public Human(String name,LocalDate birthDate,  Gender gender ){
        this( name, birthDate, null, gender);
    }
    public Human(String name,LocalDate birthDate, LocalDate deathDate,  Gender gender) {
        this.name=name;
        this.birthDate= birthDate;
        this.deathDate=deathDate;
        this.gender=gender;
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
        children.add(child);
        return children;
    }
    public List addParent(Human parent) {
        parents.add(parent);
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
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


    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ",ДР: " + birthDate + " ДС " +deathDate +" Родители: " + parents + " Дети "+ children;
    }

    /*
    public String getFatherInfo() {
        StringBuilder st = new StringBuilder();
        st.append("Father: ");
        st.append(parents.get(0).getName());
        return st.toString();
    }
    public String getMotherInfo() {
        StringBuilder st = new StringBuilder();
        st.append("Mother: ");
        st.append(parents.get(1).getName());
        return st.toString();
    }

    public String getChildrenInfo() {
        StringBuilder st = new StringBuilder();
        st.append("Children: ");
        if (children.size() != 0) {
            st.append(children.get(0).getName());
            for (int i = 0; i < children.size(); i++) {
                st.append(", ");
                st.append(children.get(i).getName());
            }
        } else st.append("null");
        return st.toString();
    }
    public Human getFather(){
            return parents.get(0);
        }
    public Human getMother(){
        return parents.get(1);
    }

    public String getInfo(){
        StringBuilder sb=new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(",  ");
        sb.append(getFatherInfo());
        sb.append(",  ");
        sb.append(getMotherInfo());
        sb.append(",  ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    */


}
