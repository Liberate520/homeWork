package FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String surname;
    private LocalDate birthdate;
    private Gender sex;
    private Human father;
    private Human mother;
    private List<Human> childrens;

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void addChildrens(Human children) {
        this.childrens.add(children);
    }

    public String getName() {
        return name;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public Human (String name, String surname, LocalDate birthdate, Gender sex){
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.childrens = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Human: " + "name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", sex=" + sex;
    }
}
