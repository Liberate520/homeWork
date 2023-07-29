package Tree;
import java.io.Serializable;

// Д.з. 4 сделать класс параметизированным

public class FamilyMember<T extends Human> extends Human implements Serializable, Comparable<T> {
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
    public int compareTo(T o) {
        return human.getName().compareTo(o.getName());
    }
}

