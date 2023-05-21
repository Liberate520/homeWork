package model.Services;

import model.famalyTree.FamilyTree;
import model.famalyTree.FileHandler;
import model.famalyTree.Savable;
import model.humans.Gender;
import model.humans.Human;

import java.util.List;

public abstract class Service {
    protected FamilyTree familyTree;
    protected Savable savable;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
        savable = new FileHandler();
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    protected Gender setGender(String gender){
        if(gender.toLowerCase().equals("male")) {
            return Gender.Male;
        } else return Gender.Female;
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
