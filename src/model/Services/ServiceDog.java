package model.Services;

import model.dogs.Dog;
import model.famalyTree.FamilyTree;
import model.famalyTree.FileHandler;
import model.famalyTree.Savable;
import model.humans.Gender;

public class ServiceDog extends Service{

    public ServiceDog(FamilyTree familyTree) {
        super(familyTree);
    }

    public ServiceDog() {
        this(new FamilyTree<>());
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void addMember(String gen, String firstName) {
        Gender gender = super.setGender(gen);
        familyTree.addMember(new Dog(gender, firstName));
    }

    public void addChild(String parentName, String gen, String name) {
        Gender gender = super.setGender(gen);
        Dog parent = (Dog) familyTree.searchByName(parentName);
        Dog child = new Dog(gender, name);
        familyTree.addMember(child);
        parent.addChild(child);
    }
}