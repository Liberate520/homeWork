package ru.gb.familyTree.person;

import ru.gb.familyTree.tree.FamilyTree;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private int id;
    FamilyTree family;
    private String firstName;//имя
    private String secondName;//отчество
    private String lastName;//фамилия
    private LocalDate startDay;//начало правления
    private LocalDate stopDay;//конец правления
    private Gender gender;

    public Person (FamilyTree family, int id, String firstName, String secondName, String lastName,
                   LocalDate startDay, LocalDate stopDay, Gender gender){
        this.setFamily(family);
        this.setId(id);
        this.setFirstName(firstName); //имя
        this.setSecondName(secondName);//отчество
        this.setLastName(lastName);//фамилия
        this.setStartDay(startDay);
        this.setStopDay(stopDay);

        this.setGender(gender);
    }

    public void setFamily(FamilyTree family){
        this.family = family;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public void setStopDay(LocalDate stopDay) {
        this.stopDay = stopDay;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public FamilyTree getFamily() {
        return family;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public LocalDate getStopDay() {
        return stopDay;
    }

    public Gender getGender() {
        return gender;
    }

    public String getGenderString() {
        if (gender == Gender.Female) {
            return "жен.";
        } else {
            return "муж.";
        }
    }
    @Override
    public String toString() {
        String start;
        String stop;
        if (getStartDay() != null) {
            start = getStartDay().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } else {
            start = "";
        }
        if (getStopDay() != null) {
            stop = getStopDay().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } else {
            stop = "";
        }
        return String.format("Персона %d: %s %s %s (%s - %s), %s.",
                getId(), getLastName(), getFirstName(), getSecondName(), start, stop, getGenderString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Person person)){
            return false;
        }
        return family.equals(person.getFamily()) && lastName.equals(person.getLastName()) &&
                secondName.equals(person.getSecondName()) && firstName.equals(person.getFirstName()) &&
                startDay.equals(person.getStartDay()) && stopDay.equals(person.getStopDay()) &&
                gender.equals(person.getGender());
    }

    @Override
    public int hashCode() {
        return 3 * getFamily().hashCode() + 7 * getLastName().hashCode() + 13 * getFirstName().hashCode() +
                17 * getSecondName().hashCode() + 24 * getStartDay().hashCode() + 32 * getStopDay().hashCode() +
                48 * getGender().hashCode();
    }
}
