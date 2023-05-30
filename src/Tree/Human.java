package Tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private static int global_id;
    private int id;
    private String name;
    private LocalDate yearOfBirth;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate yearOfBirth, Gender gender, Human father, Human mother) { //общий конструктор
        this.id = ++global_id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, LocalDate yearOfBirth, Gender gender) { // конструктор без родителей/детей
        this(name, yearOfBirth, gender, null, null);
    }

    public void addChildren(Human child){
        children.add(child);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public Gender getGender() {
        return gender;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "\nЧеловек{" +
                "№ " + id +
                ", Имя " + name + '\'' +
                ", Дата рождения " + yearOfBirth +
                ", Пол " + gender +
                ", Отец " + father +
                ", Мать " + mother +
                ", Дети " + children +
                '}';
    }
}



