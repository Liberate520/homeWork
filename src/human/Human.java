package human;

import comparators.ChildrenComparatorByAge;
import comparators.ChildrenComparatorByName;
import tree.FamilyTreeItem;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, Comparable<Human>, FamilyTreeItem {

    private String firstname;
    private String lastname;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;
    private List<Human> brothers;
    private List<Human> sisters;
    private List<Human> humanList;

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
        brothers = new ArrayList<>();
        sisters = new ArrayList<>();
    }

    public Human(String firstName, String lastname, Gender gender, Human father, Human mother) {
        this(firstName, lastname, gender, null, null, father, mother);
    }

    public String getFirstName() { return firstname; }

    public String getLastName() { return lastname;  }
    public Gender getGender() { return gender;  }
    public Human getFather() { return father; }

    @Override
    public int getAge() {
        return (int) ChronoUnit.YEARS.between(getBirthDate(), LocalDate.now());
    }

    public Human getMother() { return mother; }

    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getDeathDate() { return deathDate; }
    public List<Human> getBrothers() { return brothers; }
    public List<Human> getSisters() { return sisters; }

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

    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }
    @Override
    public void setFather(FamilyTreeItem father) {
        this.father = (Human) father;
    }

    @Override
    public void setMother(FamilyTreeItem mother) {
        this.mother = (Human) mother;
    }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setChildren(List<Human> children) { this.children = children;  }
    public void setBrothers(List<Human> brothers) { this.brothers = brothers; }
    public void setSisters(List<Human> sisters) { this.sisters = sisters; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setDeathDate(LocalDate deathDate) { this.deathDate = deathDate; }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(firstname);
        sb.append(", ");
        sb.append("Фамилия: ");
        sb.append(lastname);
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        sb.append(", ");
        sb.append(getBrothersInfo());
        sb.append(", ");
        sb.append(getSistersInfo());
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

    public String getBrothersInfo(){
        StringBuilder res = new StringBuilder();
        res.append("братья: ");
        if (brothers.size() != 0){
            res.append(brothers.get(0).getFirstName());
            for (int i = 1; i < brothers.size(); i++) {
                res.append(", ");
                res.append(brothers.get(i).getFirstName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public String getSistersInfo(){
        StringBuilder res = new StringBuilder();
        res.append("сёстры: ");
        if (sisters.size() != 0){
            res.append(sisters.get(0).getFirstName());
            for (int i = 1; i < sisters.size(); i++) {
                res.append(", ");
                res.append(sisters.get(i).getFirstName());
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

    public void childrenSortByName() { children.sort(new ChildrenComparatorByName());}

    public void childrenSortByAge() {
        children.sort(new ChildrenComparatorByAge());
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
                && Objects.equals(children, human.children) && Objects.equals(brothers, human.brothers)
                && Objects.equals(sisters, human.sisters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, birthDate, gender, mother, father, children, brothers, sisters);
    }

    @Override
    public String toString() {
        String genderString = gender == Gender.Male ? "Мужчина" : "Женщина";
        StringBuilder sb = new StringBuilder();
        sb.append(firstname).append(" ").append(lastname).append(", ");
        sb.append("Дата рождения: ").append(birthDate).append(", ");
        sb.append("Пол: ").append(genderString).append(", ");
        if (mother != null) {
            sb.append("Мать: ").append(mother.getFirstName()).append(" ").append(mother.getLastName()).append(", ");
        }
        if (father != null) {
            sb.append("Отец: ").append(father.getFirstName()).append(" ").append(father.getLastName()).append(", ");
        }
        if (brothers != null && !brothers.isEmpty()) {
            sb.append("Братья: ");
            for (Human brother : brothers) {
                sb.append(brother.getFirstName()).append(" ").append(brother.getLastName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()).append(", ");
        }
        if (sisters != null && !sisters.isEmpty()) {
            sb.append("Сестры: ");
            for (Human sister : sisters) {
                sb.append(sister.getFirstName()).append(" ").append(sister.getLastName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()).append(", ");
        }
        if (children != null && !children.isEmpty()) {
            sb.append("Дети: ");
            for (Human child : children) {
                sb.append(child.getFirstName()).append(" ").append(child.getLastName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()).append(", ");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Human o) {
        return firstname.compareTo(o.firstname);
    }


}
