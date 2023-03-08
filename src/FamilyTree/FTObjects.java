package src.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;

public class FTObjects implements Serializable {
    private String name;
    private Integer birthDay;
    private Integer DeathDay;
    private ArrayList<String> spouseName;
    private ArrayList<String> childrenName;
    private String additionalField;

    public FTObjects() {

        this.name = name;
        this.birthDay = birthDay;
        this.DeathDay = DeathDay;
        this.childrenName = childrenName;
        this.additionalField = additionalField;
    }

    public String getName() {
        return name;
    }
    public ArrayList getFamilyTree(ArrayList people) {
        return people;
    }

    public Integer getBirthDay() {
        return birthDay;
    }
    public Integer getDeathDay() { return DeathDay;}

    public ArrayList<String> getSpouseName() {
        return spouseName;
    }
    public ArrayList<String> getChildrenName(){
         return childrenName;
    }

    public boolean addSpouseName(String spouse) {
        if (!spouseName.contains(spouse)) {
            spouseName.add(spouse);
            return true;
        }
        return false;
    }

    public boolean setChildrenName(String childrenName) {
        this.childrenName.add(childrenName);
        return true;
    }

    public String getAdditionalField() {
        return additionalField;
    }

    public void setAdditionalField(String additionalField) {
        this.additionalField = additionalField;
    }

    @Override
    public String toString() {
        return "Person: " + name + ",\t years of life: " + birthDay + " -  ?" +
                ",\t sposes: " + spouseName +
                ",\t children: " + childrenName+
                ",\t years of government: " + additionalField;
    }

}