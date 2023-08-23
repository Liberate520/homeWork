package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Human implements Serializable, Comparable<Human>, Item {

    private String name;
    private Gender gender;
    private Human Father;
    private Human Mather;
    private Human children;
    private LocalDate birthday;
    private LocalDate deathday;

    public Human(String name, Gender gender, Human Father, Human Mather, Human children, LocalDate birthday, LocalDate deathday) {
        this.name = name;
        this.gender = gender;
        this.Father = Father;
        this.Mather = Mather;
        this.children = children;
        this.birthday = birthday;
        this.deathday = deathday;
    }

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, Gender gender, LocalDate birthday, LocalDate deathday) {
        this.name = name;
        this.gender = gender;
        this.Father = Father;
        this.Mather = Mather;
        this.children = children;
        this.birthday = birthday;
        this.deathday = deathday;
    }


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return Father;
    }

    public Human getMather() {
        return Mather;
    }

    public Human getChildren() {
        return children;
    }

    public LocalDate getBirthday() {
        return birthday;
    }


    public int getAge() {
        if (deathday == null) {
            return getPeriod(birthday, LocalDate.now());
        } else {
            return getPeriod(birthday, deathday);
        }
    }
    private int getPeriod(LocalDate birthday, LocalDate deathday){
            Period diff = Period.between(birthday, deathday);
            return diff.getYears();
        }


    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(gender);
        sb.append(", день рожденья: ");
        sb.append(birthday);
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append("\n");

        return sb.toString();
    }


    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}