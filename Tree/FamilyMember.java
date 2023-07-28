import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.*;

public class FamilyMember extends Human implements Serializable, Comparable<FamilyMember> {
    private String familyStatus;
    private Human human;

    public FamilyMember() {
    }
    public FamilyMember(String status, Human human) {
    }
    public FamilyMember setFamilyMember(String familyStatus, Human human) {
        FamilyMember familyMember = new FamilyMember();
        familyMember.familyStatus = familyStatus;
        familyMember.human = human;
        return familyMember;
    }

    public int getAgeFamilyMember(){
            return human.getAge();
        }
    public String getNameFamilyMember(){
        return human.getName();
    }
    @Override
    public String toString() {
        return "Член семьи: " + familyStatus + "," + human.toString() + "\n";
    }
    public String getFamilyStatus() {
        return familyStatus;
    }

    @Override
    public int compareTo(FamilyMember o) {
        return human.getName().compareTo(o.getName());
    }
}

