import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Human {

    private String name;
    private String surname;
    private LocalDate dateBirth;

    Gender gender;
    Human father;
    Human mother;

    List<Human> childList;

    public Human(String name, String surname, LocalDate dateBirth, Gender gender,
                 Human father, Human mother) {
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public LocalDate getDateBirth() {
        return this.dateBirth;
    }

    public List<Human> getChildList() {
        return childList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setFather(Human father) {
        this.father = father;
        father.addChild(this);
    }

    public void setMother(Human mother) {
        this.mother = mother;
        mother.addChild(this);
    }

    public void addChild(String name, String surname) {
        Human child = new Human(name, surname);
        child.setFather(this);
        this.childList.add(child);
    }

    public void addChild(Human child) {
        child.setFather(this);
        this.childList.add(child);
    }

    @Override
    public String toString() {
        return String.format("", this.name, this.surname, this.dateBirth, this.gender, this.childList);
    }








}
