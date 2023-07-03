package Homework.Human;

import java.time.LocalDate;

public class Human {

    protected String name;
    protected LocalDate birth;
    protected Gender gender;
    protected Human father, mother;
    //TODO добавить детей

    public Human(String name, LocalDate birth, Gender gender) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
    }

    public Human(String name, LocalDate birth, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, LocalDate birth, Gender gender, Human parent) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.father = parent;
    }

    public String getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    @Override
    public String toString() {
        if(father != null && mother != null){return "ФИО: " + name + ", " + birth + " г.р. " + "(" + (LocalDate.now().getYear() - birth.getYear()) + " лет)" + ", Пол: " + gender + ", Отец: " + father.getName() + ", Мать: " + mother.getName();}
        if(father != null && mother == null){return "ФИО: " + name + ", " + birth + " г.р. " + "(" + (LocalDate.now().getYear() - birth.getYear()) + " лет)" + ", Пол: " + gender + ", Отец: " + father.getName();}
        if(father == null && mother != null){return "ФИО: " + name + ", " + birth + " г.р. " + "(" + (LocalDate.now().getYear() - birth.getYear()) + " лет)" + ", Пол: " + gender + ", Мать: " + mother.getName();}
        else{return "ФИО: " + name + ", " + birth + " г.р. " + "(" + (LocalDate.now().getYear() - birth.getYear()) + " лет)" + ", Пол: " + gender;}
    }
}
