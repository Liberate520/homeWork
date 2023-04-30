package Model;

import java.io.Serializable;

public class Human implements Serializable {
    private String name;
    private int yearOfBirth;
    private String gender;

    public Human(String name, int yearOfBirth, String gender) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Year of Birth: " + yearOfBirth + ", Gender: " + gender;
    }
}


