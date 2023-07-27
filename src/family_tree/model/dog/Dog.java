package family_tree.model.dog;

import family_tree.model.gender.Gender;
import family_tree.model.person.Person;
import family_tree.model.tree.TreeInterface;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dog implements TreeInterface<Dog>, Serializable {

    String name;
    LocalDate birthday;
    LocalDate dayOfDeath;
    Gender gender;
    Integer idPerson;
    private ArrayList<Dog> parents;
    private ArrayList<Dog> children;
    private ArrayList<Dog> siblings;

    public Dog(String name,
               LocalDate birthday,
               LocalDate dayOfDeath,
               Gender gender,
               Integer idPerson) {
        this.name = name;
        this.birthday = birthday;
        this.dayOfDeath = dayOfDeath;
        this.gender = gender;
        this.idPerson = idPerson;
    }

    @Override
    public void addChild(Dog person) {

    }

    @Override
    public void addMother(Dog person) {

    }

    @Override
    public void addFather(Dog person) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public LocalDate getBirthday() {
        return null;
    }

    @Override
    public Integer getAge() {
        return null;
    }

    @Override
    public void setBirthday(LocalDate birthday) {

    }

    @Override
    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    @Override
    public void setDayOfDeath(LocalDate dayOfDeath) {

    }

    @Override
    public ArrayList<Dog> getParents() {
        return null;
    }

    @Override
    public Person getFather() {
        return null;
    }

    @Override
    public Person getMother() {
        return null;
    }

    @Override
    public ArrayList<Dog> getChildren() {
        return null;
    }

    @Override
    public String getMotherInfo() {
        return null;
    }

    @Override
    public String getFatherInfo() {
        return null;
    }

    @Override
    public String getDayOfDeathInfo() {
        return null;
    }

    @Override
    public String getChildrenInfo() {
        return null;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public Person getPartner() {
        return null;
    }

    @Override
    public void setPartner(Dog partner) {

    }

    @Override
    public String getPartnerInfo() {
        return null;
    }

    @Override
    public Gender getGender() {
        return null;
    }

    @Override
    public void setGender(Gender gender) {

    }

    @Override
    public ArrayList<Dog> getSiblings() {
        return null;
    }

    @Override
    public void addSibling(Dog sibling) {

    }

    @Override
    public String getSiblingsInfo() {
        return null;
    }

    @Override
    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append("Age: ");
        stringBuilder.append(getAge());
        stringBuilder.append("\n");
        stringBuilder.append("Partner: ");
        stringBuilder.append(getPartnerInfo());
        stringBuilder.append("\n");
        stringBuilder.append("family_tree.model.gender.Gender: ");
        stringBuilder.append(gender.toString());
        stringBuilder.append("\n");
        stringBuilder.append("Birthday: ");
        stringBuilder.append(birthday.toString());
        stringBuilder.append("\n");
        stringBuilder.append("Day of death: ");
        stringBuilder.append(getDayOfDeath());
        stringBuilder.append("\n");
        stringBuilder.append("Mother: ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append("\n");
        stringBuilder.append("Father: ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append("\n");
        stringBuilder.append("Children: ");
        stringBuilder.append(getChildrenInfo());
        stringBuilder.append("\n");
        stringBuilder.append("siblings: ");
        stringBuilder.append(getSiblingsInfo());
        return stringBuilder.toString();
    }

    @Override
    public void setParents(ArrayList<Dog> parents) {
        this.parents = parents;
    }

    @Override
    public void setChildren(ArrayList<Dog> children) {
        this.children = children;
    }

    @Override
    public void setSiblings(ArrayList<Dog> siblings) {
        this.siblings = siblings;
    }
}
