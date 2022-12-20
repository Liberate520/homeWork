package Seminars_OOP.HW_1;

public class Human {
    String name;
    int yearOfBirth;
    String gender;
    String father;
    String mother;
    
    // Не поняла, как реализовать список детей и добавление детей родителям

    public Human(String name, int yearOfBirth, String gender, String father, String mother) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + yearOfBirth + ", (" + gender + ")";
    }

}
