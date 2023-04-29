package module.essence;

import java.io.Serializable;
import java.util.*;

public class Human implements Serializable, Essence<Human> {
    public String name;
    private Calendar date_of_birth;
    private Integer day;
    private Integer month;
    private Integer year;
    private Gender gender;
    private final List<Human> children;
    private final List<Human> parents;
    private Human In_marriage_with;


    public Human(String name, Integer day, Integer month, Integer year, Gender gender) {
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.name = name;
        this.gender = gender;
        this.date_of_birth = new GregorianCalendar(year, month, day);
        this.In_marriage_with = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth.getTime();
    }

    public void setDate_of_birth(Calendar date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human children) {
        this.children.add(children);
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(Human parent) {
        parents.add(parent);
    }

    public void setParents(Human parent1, Human parent2) {
        parents.add(parent1);
        parents.add(parent2);
    }

    public Human getIn_marriage_with() {
        return In_marriage_with;
    }

    public void setIn_marriage_with(Human in_marriage_with) {
        this.In_marriage_with = in_marriage_with;
    }

    @Override
    public String toString() {
        return name + " ("+ getDate_of_birth()+") ";
    }
}