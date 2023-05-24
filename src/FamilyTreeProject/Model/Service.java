package model;
import java.io.Serializable;
import java.util.List;

import familyTree.FamilyTree;
import fileHandler.FileHandler;
import fileHandler.Savable;
import human.FamilyTreeObject;
import human.Gender;
import human.Human;

public class Service implements Savable{
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Service(FamilyTree<Human> familyTree){
        this.familyTree = familyTree;
        this.fileHandler = new FileHandler();
    }
    public Service(){
        this (new FamilyTree<Human>());
    }

    // public void addMember(Human human, Human mother, Human father){
    //     familyTree.addMember(human, mother, father);
    // }
    public Human createHuman(String firstName, String lastName, int dayOfBirth, int monthOfBirth,
    int yearOfBirth){
        return new Human(firstName, lastName, Gender.Male, dayOfBirth,
        monthOfBirth, yearOfBirth);
    }

    public void addMember(Human human){
        familyTree.addMember(human);
    }

    public void addMember(String firstName, String lastName, int dayOfBirth, int monthOfBirth,
    int yearOfBirth){
        familyTree.addMember((Human)createHuman(firstName, lastName, dayOfBirth,
        monthOfBirth, yearOfBirth));
    }

    public List<Human> getAllMembers(){
        return familyTree.getAllMembers();  
    }

    public String getAllMembersAsString(){
        StringBuilder sb = new StringBuilder();
        for(Human human: familyTree.getAllMembers()){
            sb.append(human.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<Human> getMembersByName(String name){
        return familyTree.getMembersByName(name);
    }

    public String getMembersByNameAsString(String name){
        StringBuilder sb = new StringBuilder();
        for(Human human: familyTree.getMembersByName(name)){
            sb.append(human.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByAge(){
        familyTree.sortByAge();
    }
    
    @Override
    public boolean save(Serializable serializable, String path){
        return fileHandler.save(serializable, path);
    }

    @Override
    public FamilyTree<FamilyTreeObject> load(String path){
        return fileHandler.load(path);
    }

}
