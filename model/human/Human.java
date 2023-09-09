package model.human;
import model.human.comparators.HumanComparatorAge;
import model.human.comparators.HumanComparatorByName;
import model.tree.humanGroup.HumanGroupItem;
import model.tree.humanGroup.ListAllHuman;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Human<E> implements Comparable<Human>, HumanGroupItem {
    private String fullName;
    private Gender gender;
    private  LocalDate birthDate;
    private  LocalDate deathDate;
    private ArrayList listAllHuman;
    private ArrayList treeNode;

    public Human(String fullName, Gender gender, LocalDate birthDate,LocalDate deathDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;

    }

    public Human(String fullName, Gender gender, LocalDate birthDate) {
        this(fullName, gender, birthDate, null);
    }


    @Override
    public String toString() {
        return  "Имя =" + getFullName()+ '\'' +
                ", пол =" + getGender() +
                ", возраст =" + getAge() +
                '}';
    }



    public String getFullName() { return fullName; }



    public Gender getGender() {
        return gender;

    }
    public LocalDate getBirthDate() {
        return birthDate;
    }



    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    @Override
    public ArrayList addHumans() {
        return listAllHuman;
    }



    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }


    public String getInfo() {
        String sb = " имя: " +
                getFullName() +
                ", пол: " +
                getGender() +
                ", возраст: " +
                getAge();

        return sb;
    }



    @Override
    public String searchByName() {
        return fullName;
    }

    @Override
    public ArrayList familyNode() {
        return treeNode;
    }



    public  void getSortByName() {
        listAllHuman.sort(new HumanComparatorByName<>());
    }

    public  void getSortByAge() {
        listAllHuman.sort(new HumanComparatorAge<>());
    }

    @Override
    public int compareTo(Human o) {
        return fullName.compareTo(o.fullName);
    }
}

