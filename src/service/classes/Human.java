package service.classes;

import java.io.Serializable;
import java.util.Objects;

import static service.classes.Marriage.NO;

/*
Базовый класс
 */
public abstract class Human  implements Serializable {

    protected String name;
    protected String familyName;
    protected Gender gender;
    protected Marriage marriageStatus;
    protected int dbIndex;

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public Marriage getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(Marriage marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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

    public Human(String name, String familyName, Gender gender) {
        this.name = name;
        this.familyName = familyName;
        this.gender = gender;
        this.marriageStatus = NO;
    }

    public Human() {
        this("", "", Gender.MALE);
    }


    @Override
    public String toString() {
        return String.format("Name: %12s, Family_name: %12s, Gender: %7s, Married: %5s\n", name, familyName, gender,
                marriageStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return name.equals(human.name) && familyName.equals(human.familyName) && gender == human.gender && marriageStatus == human.marriageStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, familyName, gender, marriageStatus);
    }
}
