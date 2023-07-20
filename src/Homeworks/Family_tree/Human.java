package Homeworks.Family_tree;

public class Human {
    private String name;
    private Gender gender;

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
