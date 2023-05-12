package model;

import model.dogs.Dog;
import model.famalyTree.FamilyTree;
import model.famalyTree.FileHandler;
import model.famalyTree.Savable;
import model.humans.*;

public class Service{
    private FamilyTree familyTree;
    private Savable savable;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
        savable = new FileHandler();
    }

    public Service() {
        this(new FamilyTree());
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

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

    private Gender setGender(String gender){
        if(gender.toLowerCase().equals("male")) {
            return Gender.Male;
        } else return Gender.Female;
    }

    public void addHuman(String gen, String firstName, String lastName) {
        Gender gender = setGender(gen);
        familyTree.addMember(new Human(gender, firstName, lastName));
    }

    public void addDog(String gen, String firstName) {
        Gender gender = setGender(gen);
        familyTree.addMember(new Dog(gender, firstName));
    }

    public void addChild(String parentName, String gen, String name) {
        Gender gender = setGender(gen);
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

    public String getInfo(){
        return familyTree.getInfo();
    }

    public void save(String path){
        savable.save(familyTree, path);
    }

    public void upload(String path) {
        this.familyTree = (FamilyTree) savable.upload(path);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortAmountOfChildren(){
        familyTree.sortAmountOfChildren();
    }
}