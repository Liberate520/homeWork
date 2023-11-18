package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.tree.TreeItem;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Human implements Serializable, TreeItem {
    private int id;
    private String lastname;
    private String name;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private Map<String, Human> parents;
    private List<Human> children;
    private Human spouse;

    public Human(String lastname, String name, Gender gender) {
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        Map<String, Human> parents = new HashMap<>();
        this.parents = parents;
        List<Human> children = new ArrayList<>();
        this.children = children;
    }

    public String getAge() {
        if (this.deathday == null) {
            return Integer.toString(Period.between(this.birthday, LocalDate.now()).getYears());
        }
        else {
            StringBuilder stringBuilder = new StringBuilder(this.lastname);
            stringBuilder.append(" ").append(this.name).append(" умер(ла) в возрасте ");
            stringBuilder.append(Period.between(this.birthday, this.deathday).getYears());
            stringBuilder.append(" лет.");
            return stringBuilder.toString();
        }
    }

    public int age() {
        if (this.birthday == null) return 0;
        if (this.deathday == null) {
            return Period.between(this.birthday, LocalDate.now()).getYears();
        }
        else {
            return Period.between(this.birthday, this.deathday).getYears();
        }
    }

    public int getId() {
        return this.id;
    }

    public String getLastname() { return lastname; }

    public String getName() { return name; }

    public LocalDate getBirthday() { return birthday; }

    public LocalDate getDeathday() { return deathday; }

    public Gender getGender() { return gender; }

    public String getParents() {
        if (!(this.parents).isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("Родители: ");
            stringBuilder.append(this.parents);
            return stringBuilder.toString();
        }
        return null;
    }

    public String getChildren() {
        if (!(this.children).isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("Дети: ");
            stringBuilder.append(this.children);
            return stringBuilder.toString();
        }
        return null;
    }

    public String getSpouse() {
        if (this.spouse != null) {
            StringBuilder stringBuilder = new StringBuilder("Супруг(а): ");
            stringBuilder.append(this.spouse);
            return stringBuilder.toString();
        }
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private void setParent(Human human) {
        if (human.gender == Gender.Male) {
            this.parents.put("отец",human);
        }
        else this.parents.put("мать",human);
    }

    public void setChild(Human human) { // в main можно использовать только этот метод, т.к. он привязывает родителей автоматически
        if(!children.contains(human)) {
            this.children.add(human);
            human.setParent(this);
        }
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }


    @Override
    // Сюда можно было добавить еще параметров, но метод часто используется,
    // в консоли было бы неудобочитаемо
    public String toString() {
        return "ID:" + id + " Фамилия: " + lastname + ", имя: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return lastname.equals(human.getLastname()) && name.equals(human.getName()) && gender.equals(human.gender);
    }

    @Override
    public int hashCode() {
        return 7 * lastname.hashCode() + 13 * name.hashCode() + 24 * gender.hashCode();
    }
}

