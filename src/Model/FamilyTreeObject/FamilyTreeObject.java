package Model.FamilyTreeObject;



import Model.FamilyTree.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FamilyTreeObject implements Serializable,Comparable {
    private String name;
    private String surname;
    private Date dateOfBirth = new Date();
    private Date dateOfDeath = new Date();
    private FamilyTreeObject mother;
    private FamilyTreeObject father;
    private String gender;
    private List<FamilyTreeObject> childrens = new ArrayList<FamilyTreeObject>();
    FamilyTree familyTree;

    public FamilyTreeObject(FamilyTree familyTree, String name, String surname,
                 Date dateOfBirth, Date dateOfDead, FamilyTreeObject mother, FamilyTreeObject father,String gender, List childrens){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDead;
        this.mother = mother;
        this.father = father;
        this.gender = gender;
        this.childrens = childrens;
        this.familyTree = familyTree;
    }
    public FamilyTreeObject (FamilyTree familyTree, String name, String surname, String gender){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.familyTree = familyTree;
    }

    public void setMother(FamilyTreeObject familyTreeObject){
        if(mother==null || !mother.equals(familyTreeObject)) {
            this.mother = familyTreeObject;
            familyTreeObject.addChildren(this);
            familyTree.addElement(familyTreeObject);
        }

    }
    public void setFather(FamilyTreeObject familyTreeObject){
        if(father==null || !father.equals(familyTreeObject)){
            this.father = familyTreeObject;
            familyTreeObject.addChildren(this);
            familyTree.addElement(familyTreeObject);
        }

    }
    public void addChildren(FamilyTreeObject familyTreeObject){
        if(!childrens.contains(familyTreeObject)){
            this.childrens.add(familyTreeObject);
            if (gender.equals("Женский")){
                familyTreeObject.setMother(this);
            }
            if (gender.equals("Мужской")){
                familyTreeObject.setFather(this);
            }
            familyTree.addElement(familyTreeObject);
        }


    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public FamilyTreeObject getMother() {
        return mother;
    }

    public FamilyTreeObject getFather() {
        return father;
    }

    public String getGender() {
        return gender;
    }

    public List<FamilyTreeObject> getChildrens() {
        return childrens;
    }

    @Override
    public String toString() {
        return "Model.FamilyTreeObject.FamilyTreeObject.Humans.Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FamilyTreeObject)) return false;
        FamilyTreeObject familyTreeObject = (FamilyTreeObject) o;
        return name.equals(familyTreeObject.name) && surname.equals(familyTreeObject.surname) && dateOfBirth.equals(familyTreeObject.dateOfBirth) && gender.equals(familyTreeObject.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirth, gender);
    }

    @Override
    public int compareTo(Object o) {
        FamilyTreeObject x = (FamilyTreeObject) o;
        return this.surname.compareTo(x.surname);
    }


}

