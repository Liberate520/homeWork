package member;

import java.util.ArrayList;
import java.util.List;

public class Parent extends FamilyMember {
    private List<FamilyMember> children;

    public Parent(String name, String surname, String patronymicName, Gender gender, String birthDate) {
        super(name, surname, patronymicName, gender, birthDate);
        this.children = new ArrayList<>();
    }

    public Parent(String name, String surname, String patronymicName, Gender gender, String birthDate, String deathDate) {
        super(name, surname, patronymicName, gender, birthDate, deathDate);
        this.children = new ArrayList<>();
    }

    public void addChild(FamilyMember child){
        children.add(child);
    }

    public String getChildren(){
        return children.toString();
    }
}
