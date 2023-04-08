package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Базовый класс человека
 */
public class Human implements Serializable {
    private Gender gender;
    private String name;
    private String secondName;
    private String surname;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(Gender gender, String name, String secondName, String surname, LocalDate dateBirth, LocalDate dateDeath, Human father, Human mother) {
        this.gender = gender;
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.father = father;
        this.mother = mother;
    }

    public Human(Gender gender, String name, String secondName, String surname, LocalDate dateBirth, LocalDate dateDeath) {
        this(gender, name, secondName, surname, dateBirth, dateDeath, null, null);
    }

    public Human(Gender gender, String name, String secondName, String surname, LocalDate dateBirth) {
        this(gender, name, secondName, surname, dateBirth, null, null, null);
    }

    public Human() {
        this(Gender.indefinite, "", "", "", null, null, null, null);
    }


    // getter
    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setDateDeath(LocalDate dateDeath) {
        this.dateDeath = dateDeath;
    }

    public void setFather(Human father) {
        this.father = father;
        if (father != null) {
            father.addChild(this);
        }
    }

    public void setMother(Human mother) {
        this.mother = mother;
        if (mother != null) {
            mother.addChild(this);
        }
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    /**
     * Метод добавляет ребенка в список детей родителя
     */
    public void addChild(Human child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s%s)", this.name, this.surname, this.dateBirth, this.dateDeath == null ? "" : String.format(" - %s", this.dateDeath));
    }
}
