package family_tree.human;

import family_tree.base.TreeHub;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Human<E> implements TreeHub<E>, Serializable {
    private final String lastName;
    private final String firstName;
    private final String gender;
    private final String fondation;
    private final String position;
    private final String socialPosition;
    private final double income;
    private final int age;
    private double id;


    public <children> Human(String lastName, String firstName, String gender, String position, String socialPosition, String fondation, double income, int age, double id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.position = position;
        this.socialPosition = socialPosition;
        this.fondation = fondation;
        this.income = income;
        this.age = age;
        this.id = id;
        List<Human<?>> children = new ArrayList<>();

    }


    @Override
    public String toString() {
        return "===============================" +
                "\nчлен семьи: " + lastName + " " + firstName +
                "\nпол: " + gender +
                "\nположение: " + position +
                "\nсоциальный статус: " + socialPosition +
                "\nобразование: " + fondation +
//                "\nКто дети: " + children +
                "\nдоходы: " + income +
                "\nвозраст: " + age +
                "\nid: " + id +
                "\n===============================";

    }

    public String getLastName() {
        return lastName;
    }


    public int getAge() {
        return age;
    }

    @Override
    public void setId(long id) {

    }

    public long getId() {
        return (long) id;
    }

    @Override
    public String getName() {
        return null;
    }


    public void setId(double id) {
        this.id = id;
    }



}

