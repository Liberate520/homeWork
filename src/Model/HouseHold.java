package Model;

import java.time.LocalDate;

public abstract class HouseHold {
    private String name;
    private int age;
    private Gender gender;

    public HouseHold(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("\n");
        sb.append(this.getAge()).append("\n");
        sb.append(this.getGender()).append("\n");
        return sb.toString();
    }
}
