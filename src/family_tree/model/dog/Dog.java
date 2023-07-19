package family_tree.model.dog;

import family_tree.model.gender.Gender;
import family_tree.model.person.Person;
import family_tree.model.tree.Treeable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

// TODO: 7/16/23 Class Dog
public class Dog implements Treeable<Dog>, Serializable {
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
        return null;
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
        return null;
    }
}
