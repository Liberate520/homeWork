package Homeworks.Family_tree;

import java.io.Serializable;

public class Human implements Serializable {
    private String name;
    private Gender gender;

    @Override
    public String toString() {
        return "\nHuman [name=" + name + ", gender=" + gender + "]";
    }

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }
}
