package model.human;

import model.familytree.FamilyTreeItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyTreeItem {
    private Integer id;
    private Gender gender;
    private String name;
    private String lastName;
    private Integer age;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human partner;

    public Human(Gender gender, String name, String lastName, Integer age) {
        this.gender = gender;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.children = new ArrayList<>();
        this.id = makeHashCode();

    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        System.out.println(this.lastName);
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private void setMother(Human mother) {
        this.mother = mother;
    }

    private void setFather(Human father) {
        this.father = father;
    }

    private void addChild(Human child) {
        if (!this.children.contains(child)) {this.children.add(child);}
    }

    private void setPartner(Human partner) {
        this.partner = partner;
        partner.setPartner(this);
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getPartner() {
        return partner;
    }

    public Integer getId() {
        this.id = makeHashCode();
        return id;
    }

    private int makeHashCode() {
       return this.gender.hashCode() +
               this.name.hashCode() +
               this.lastName.hashCode() +
               this.age.hashCode() +
               this.children.hashCode() * 32;
    }

    public String getGeneralInfo() {
        String separ = ", ";
        String stringBuilder = "[ " +
                this.getName() + separ +
                this.getLastname() + separ +
                this.getAge() + separ +
                this.getGender() + separ +
                this.getId() + "]";
        return stringBuilder;
    }

    @Override
    public int hashCode() {
        return makeHashCode();
    }

    @Override
    public String toString() {
        return "Human{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
