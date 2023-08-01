package Model;

import java.io.Serializable;
// Д.з. 4 сделать класс параметизированным

public class FamilyMember<T extends Human> extends Human implements Serializable, Comparable<T> {
    private String familyStatus;
    private Human human;

    public FamilyMember addFamilyMemberStatus (String familyStatus, Human human) {
        this.familyStatus = familyStatus;
        this.human = human;
        return this;
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

