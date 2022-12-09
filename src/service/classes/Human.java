package service.classes;

import java.util.Objects;

import static service.classes.Marrige.NO;

/*
Базовый класс
 */
public abstract class Human {

    protected String name;
    protected String familyname;
    protected Gender gender;
    protected Marrige marigeStatus;
    protected int dbIndex;

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

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
        this.marigeStatus = NO;
    }

    public Human() {
        this("", "", Gender.MALE);
    }

    public void getInfo() {
        System.out.printf("Name: %12s, Family_name: %12s, Gender: %7s, Married: %5s\n", name, familyname, gender,
                marigeStatus);
    }

    @Override
    public String toString() {
        return String.format("Name: %12s, Family_name: %12s, Gender: %7s, Married: %5s\n", name, familyname, gender,
                marigeStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return name.equals(human.name) && familyname.equals(human.familyname) && gender == human.gender && marigeStatus == human.marigeStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, familyname, gender, marigeStatus);
    }
}
