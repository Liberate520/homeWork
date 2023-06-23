package human;

import tree.FamilyTreeItem;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable,Comparable<Human>, FamilyTreeItem {

    private String firstname;
    private String lastname;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String firstName, String lastname, Gender gender, LocalDate birthDate) {
        this(firstName, lastname, gender, birthDate, null, null, null);
    }

    public Human(String firstName, String lastname, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.firstname = firstName;
        this.lastname = lastname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(String firstName, String lastname, Gender gender, Human father, Human mother) {
        this(firstName, lastname, gender, null, null, father, mother);
    }

    public String getFirstName() { return firstname; }
    public String getLastName() { return lastname;  }

    public Human getFather() { return father; }

    @Override
    public int getAge() {
        return (int) ChronoUnit.YEARS.between(getBirthDate(), LocalDate.now());
    }

    public Human getMother() { return mother; }
    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getDeathDate() { return deathDate; }

    @Override
    public void addChild(FamilyTreeItem child) {
        if (this.gender == Gender.Male) {
            child.setFather(this);
        } else if (this.gender == Gender.Female) {
            child.setMother(this);
        }
        children.add((Human) child);
    }

    public List<FamilyTreeItem> getChildren() {
        List<FamilyTreeItem> childrenList = new ArrayList<>();
        for (Human child : children) {
            childrenList.add((FamilyTreeItem) child);
        }
        return childrenList;
    }

    @Override
    public void setFather(FamilyTreeItem father) {
        this.father = (Human) father;
    }

    @Override
    public void setMother(FamilyTreeItem mother) {
        this.mother = (Human) mother;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(firstname);
        sb.append(", ");
        sb.append("Фамилия: ");
        sb.append(lastname);
        sb.append(", ");
        sb.append("Дата рождения: ");
        sb.append(birthDate);
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null){
            res += getFather().getFirstName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

      public String getMotherInfo(){
        String res = "мать: ";
        if (mother != null){
            res += getMother().getFirstName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getFirstName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getFirstName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public boolean addChild(Human child) {
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Human human = (Human) o;
        return Objects.equals(firstname, human.firstname) && Objects.equals(lastname, human.lastname)
                && Objects.equals(birthDate, human.birthDate) && gender == human.gender
                && Objects.equals(mother, human.mother) && Objects.equals(father, human.father)
                && Objects.equals(children, human.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, birthDate, gender, mother, father, children);
    }

    @Override
    public int compareTo(Human o)
    {
        return firstname.compareToIgnoreCase(o.firstname);
    }

}
