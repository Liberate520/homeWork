package classes;

import java.util.ArrayList;

public class Human {

    protected String name;
    protected String familyname;
    protected Gender gender;
    protected Marrige marigeStatus;


    public Marrige getMarigeStatus() {
        return marigeStatus;
    }

    public void setMarigeStatus(Marrige marigeStatus) {
        this.marigeStatus = marigeStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(int id) {
        if (id == 1) {
            this.gender = Gender.MALE;
        } else {
            this.gender = Gender.FEMALE;
        }
    }

    public Human(String name, String familyname, Gender gender) {
        this.name = name;
        this.familyname = familyname;
        this.gender = gender;
        this.marigeStatus = Marrige.NO;
    }

    public Human() {
        this("", "", Gender.MALE);
    }

    public void getInfo() {
        System.out.printf("Name: %12s, Family_name: %12s, Gender: %7s, Married: %5s\n", name, familyname, gender,
                marigeStatus);
    }
}
