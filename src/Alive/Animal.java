package Alive;

import Alive.enums.Gender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Animal implements Serializable {
    protected String name;
    protected Gender gender;
    protected int age;

    public Date born;

    public Date die;
    private List<Animal> children;


    public Animal(String name, Gender gender, int age, Date born, Date die) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.born=born;
        this.die=die;
    }
    public Animal(String name, Gender gender, int age, Date born) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.born=born;
    }

    abstract public List getChildren();


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}