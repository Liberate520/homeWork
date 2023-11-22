package FamilyTree_homework;

import java.time.LocalDate;
import java.util.List;

public class Human {


    String name;
    gender gender;
    LocalDate birthDate;
    String mother;
    String father;
    List<Human> children;

    public family_tree.gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(family_tree.gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "name: " + name + ", gender: " + gender + ", birthday: " + birthDate + ", children: " + children + ", father: " + father + ", mother: " + mother;
    }

}
