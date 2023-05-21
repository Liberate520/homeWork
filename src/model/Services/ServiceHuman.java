package model.Services;

import model.famalyTree.FamilyTree;
import model.humans.*;

import java.util.List;

public class ServiceHuman extends Service implements ServiceMarry {

    public ServiceHuman(FamilyTree familyTree) {
        super(familyTree);
    }

    public ServiceHuman() {
        this(new FamilyTree());
    }

    @Override
    public void getMarried(String human1Name, String human2Name) {
        Human human1 = (Human) familyTree.searchByName(human1Name);
        Human human2 = (Human) familyTree.searchByName(human2Name);
        human1.setPartner(human2);
        human2.setPartner(human1);
        if (human1.getGender().equals(Gender.Female)) {
            human1.setLastName(human2.getLastName() + "а");
        } else {
            human2.setLastName(human1.getLastName() + "а");
        }
        if (!familyTree.getFamilyMembers().contains(human1)) {
            familyTree.addMember(human1);
        }
        if (!familyTree.getFamilyMembers().contains(human2)) {
            familyTree.addMember(human2);
        }
    }

    public void addMember(String gen, String firstName, String lastName) {
        Gender gender = super.setGender(gen);
        familyTree.addMember(new Human(gender, firstName, lastName));
    }

    public void addChild(String parentName, String gen, String name) {
        Gender gender = super.setGender(gen);
        Human parent = (Human) familyTree.searchByName(parentName);
        Human child = new Human(gender, name);
        if (child.getGender().equals(Gender.Female)) {
            if (parent.getGender().equals(Gender.Female)) {
                child.setLastName(parent.getLastName());
            } else {
                child.setLastName(parent.getPartner().getLastName());
            }
        } else {
            if (parent.getGender().equals(Gender.Female)) {
                child.setLastName(parent.getPartner().getLastName());
            } else {
                child.setLastName(parent.getLastName());
            }
        }
        if (parent.getGender().equals(Gender.Female)) {
            child.setMother(parent);
            child.setFather(parent.getPartner());
        } else {
            child.setFather(parent);
            child.setMother(parent.getPartner());
        }
        familyTree.addMember(child);
        parent.addChild(child);
        parent.getPartner().addChild(child);
    }
}