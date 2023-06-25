package Hw.sem1;

import java.time.LocalDate;

class Person {
    private String name;
    private Gender gender;
    private LocalDate birthDate;

    public Person(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                '}';
    }
}