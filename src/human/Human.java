package human;

import familyTree.FamilyTreeItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, FamilyTreeItem {
    private int id;
    private String firstName;
    private String lastName;
    private String  birthday;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(int id, String firstName, String lastName, String birthday, Gender gender,Human mother,Human father){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();

    }public Human(int id, String firstName, String lastName, String birthday, Gender gender){
        this(id, firstName, lastName,birthday, gender, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return firstName.equals(human.firstName) &&
                lastName.equals(human.lastName) &&
                birthday.equals(human.birthday) &&
                gender.equals(human.gender) &&
                Objects.equals(mother, human.mother) &&
                Objects.equals(father, human.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, gender);
    }

    @Override
    public String toString() {
        return "[" + id +
                " " + firstName +
                " " + lastName +
                ", " + birthday +
                ", " + gender +
                ", Мать: " + getMotherFullName() +
                ", Отец: " + getFatherFullName() +
                ", Детей: " + getNumberOfChildren() +
                ']';
    }

    public Human getFather() {
        return this.father;
    }

    private String getFatherFullName(){
        if (this.father != null){
            return this.getFather().getFullName();
        } else {
            return "Неизвестен";
        }

    }private String getMotherFullName(){
        if (this.mother != null){
            return this.getMother().getFullName();
        } else {
            return "Неизвестна";
        }
    }


    public Human getMother() {
        return this.mother;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public int getId() {
        return id;
    }
    public String getNumberOfChildren(){
        if (children.isEmpty()) return "Нет";
        return String.valueOf(children.size());
    }

    public void setMother(Human mother) {
        if (this.mother == null && mother.gender != Gender.Male) {
            this.mother = mother;
        }
    }

    public void setFather(Human father) {
        if (this.father == null && father.gender != Gender.Female) {
            this.father = father;
        }
    }
    @Override
    public void setChildren(Object human){
        if (!children.contains((Human) human)) {
            children.add((Human) human);
        }
    }
}
