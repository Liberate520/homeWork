import java.io.Serializable;
import java.util.List;
import java.util.*;

public class FamilyMember extends Human implements Serializable {
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
    @Override
    public String toString() {
        return "Член семьи: " + familyStatus + "," + human.toString() + "\n";
    }
    public String getFamilyStatus() {
        return familyStatus;
    }
}

