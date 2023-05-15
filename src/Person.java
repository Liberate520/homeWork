import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, FamilyTreeItem {
    private Gender gender;
    private String firstName;
    private String secondName;
    private Integer born;
    private Integer die;
    private String motherFirstName;
    private String motherSecondName;
    private String fatherFirstName;
    private String fatherSecondName;

    public Person(String firstName, String secondName, Gender gender, Integer born, Integer die) {
        this.gender = gender;
        this.firstName = firstName;
        this.secondName = secondName;
        this.born = born;
        this.die = die;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    public int getDie() {
        return die;
    }

    public void setDie(Integer die) {
        this.die = die;
    }

    public String getMotherFirstName() {
        return motherFirstName;
    }

    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    public String getMotherSecondName() {
        return motherSecondName;
    }

    public void setMotherSecondName(String motherSecondName) {
        this.motherSecondName = motherSecondName;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    public String getFatherSecondName() {
        return fatherSecondName;
    }

    public void setFatherSecondName(String fatherSecondName) {
        this.fatherSecondName = fatherSecondName;
    }

    @Override
    public String toString() {
        return "Person: " + firstName + ", " + secondName + ", " + gender +
                ", lived from " + born + " to " + die;
    }
}
