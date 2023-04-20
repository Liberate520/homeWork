package Tree.homeWork.src;

import java.util.Date;

public class Human {
    private String name;
    private int age;
    private int DateOfDeath;
    private int DateOfBirth;
    private Gender gender;
    private Human mother;
    private Human father;
    //private List<Human> children;
    public Human(String name, int age, int DateOfBirth, int DateOfDeath, Gender gender){
        this.name = name;
        this.age = age;
        this.DateOfBirth = DateOfBirth;
        this.DateOfDeath = DateOfDeath;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public int age() {
        return age;
    }
    public int DateOfBirth() {
        return DateOfBirth;
    }
    public int DateOfDeath() {
        return DateOfDeath;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Human(Human mother) {
        this.mother = mother;
    }
    @Override
    public String toString() {
        return name + ". Age - " +  age + " " + gender;
    }
}
