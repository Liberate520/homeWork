package Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Human implements Serializable {
    int id;
    private String status;
    private String name;
    private String surname;
    public LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    public HashSet<Human> children;


    public Human(int id, String status, String name, String surname, LocalDate birthDate, Human mother, Human father) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
        children = new HashSet<>();
    }

    public Human(int id, String status, String name, String surname, LocalDate birthDate) {
        this(id, status, name, surname, birthDate, null, null);
    }

    public Human(String status, String name, String surname, LocalDate birthDate) {
        this(-1, status, name, surname, birthDate, null, null);
    }

    public void addChild(Human h) {
            children.add(h);
    }

        @Override
    public String toString() {
        return String.format("\n%s: " + "%s %s, " + "дата рождения: %tF, " + "мать: %s, " + "отец: %s", status, surname, name, birthDate, this.getMotherName(), this.getFatherName());
    }

    @Override
    public boolean equals(Object obj) {
        Human t = (Human) obj;
        return name == t.name && surname == t.surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, deathDate, mother, father);
    }

    public String getMotherName() {
        if (this.getMother() != null)
            return String.format("%s %s", this.getMother().surname, this.getMother().name);
        return "неизвестна";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFatherName() {
        if (this.getFather() != null)
            return String.format("%s %s", this.getFather().surname, this.getFather().name);
        return "неизвестен";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public HashSet<Human> getChildren() {
        return children;
    }

    public void setChildren(HashSet<Human> children) {
        this.children = children;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = status;
    }

}
