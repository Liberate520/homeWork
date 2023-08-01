package ru.gb.model.human;

import ru.gb.model.data.Gender;
import ru.gb.model.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyTreeItem<Human> {
    private Gender gender;
    private String name;
    private LocalDate birthday;
    private LocalDate dayOfDeath;
    private List<Human> children;
    private List<Human> parents;
    private long id;
    public Human (String name, LocalDate birthday, Gender gender){
        this(name, birthday, gender, null, null, null);
    }
    public Human(String name, LocalDate birthday, Gender gender, Human mother, Human father) {
        this(name, birthday, gender, mother, father, null);
    }
    public Human(String name, LocalDate birthday, Gender gender, Human mother, Human father, LocalDate dayOfDeath) {
        id = -1;
        this.name = name;
        this.birthday = birthday;
        this.dayOfDeath = dayOfDeath;
        this.gender = gender;
        parents = new ArrayList<>();
        if (father != null) {
            this.parents.add(father);
        }
        if (mother != null) {
            this.parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addChild(Human child) {
        children.add(child);
    }
    public void addParent(Human parent) {
        parents.add(parent);
    }

    public List<Human> getParents() {
        return parents;
    }

    public Human getFather() {
        for (Human parent: parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }
    public String getFatherName() {
        if (getFather() != null) {
            return getFather().getName();
        }
        return "Unknown";
    }
    public Human getMother() {
        for (Human parent: parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }
    public String getMotherName() {
        if (getMother() != null) {
            return getMother().getName();
        }
        return "Unknown";
    }
    public List<Human> getChildren() {
        return children;
    }
    public String getChildrenNames() {
        if (children.size() == 0) {
            return "Unknown";
        }
        StringBuilder childrenNames = new StringBuilder();
        for (Human child : children) {
            childrenNames.append(child.getName()).append(", ");
        }
        // Если есть дети, удаляем лишнюю запятую и пробел справа
        if (childrenNames.length() > 0) {
            childrenNames.delete(childrenNames.length() - 2, childrenNames.length());
        }
        return childrenNames.toString();
    }
    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }
    public long getAge(){
        if (this.dayOfDeath == null) {
            LocalDate currentDate = LocalDate.now();
            return birthday.until(currentDate, ChronoUnit.YEARS);
        }
        return dayOfDeath.until(birthday, ChronoUnit.YEARS);
    }

    @Override
    public String toString() {
        return  "Id: " +
                this.id +
                ", имя: " +
                getName() +
                ", пол: " +
                getGender() +
                ", возраст: " +
                getAge() +
                ", отец: " +
                getFatherName() +
                ", мать: " +
                getMotherName() +
                ", дети: " +
                getChildrenNames();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        return id == human.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
