package model;

import java.time.LocalDate;
import java.util.List;

public class Dog implements TreeItem<Dog> {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Dog father;
    private Dog mother;
    private List<Dog> children;

    public Dog(String name, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Dog getFather() {
        return father;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public Dog getMother() {
        return mother;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public List<Dog> getChildren() {
        return children;
    }

    @Override
    public String toString() {

        String f1 = "UNKNOWN";
        String m1 = "UNKNOWN";


        if(father != null) f1 = father.getName();
        if(mother != null) m1 = mother.getName();

        return  "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", father=" + f1 +
                ", mother=" + m1;
    }
}
