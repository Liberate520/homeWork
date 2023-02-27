package src.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;

public class FTObjects implements Serializable {
    private String name;
    private Integer birthDay;
    private ArrayList<String> spouseName;
    private ArrayList<String> childrenName;
    private String additionalField;

    public FTObjects() {
        this.name = name;
        this.birthDay = birthDay;
        this.childrenName = childrenName;
        this.additionalField = additionalField;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public ArrayList<String> getSpouseName() {
        return spouseName;
    }

    public void addSposeName(String spose) {
        if (!spouseName.contains(spose)) {
            spouseName.add(spose);
            System.out.printf("The spose: %s added to person: %s\n", spose, name);
        }
        else System.out.printf("There is already such a record: %s\n", name);
    }

    public void setChildrenName(String childrenName) {
        this.childrenName.add(childrenName);
    }

    public String getAdditionalField() {
        return additionalField;
    }

    public void setAdditionalField(String additionalField) {
        this.additionalField = additionalField;
    }
}
