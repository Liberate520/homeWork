package model;
import java.io.Serializable;
import java.util.List;

import model.familyTree.FamilyTree;
import model.fileHandler.FileHandler;
import model.fileHandler.Savable;
import model.human.FamilyTreeObject;
import model.human.Gender;
import model.human.Human;

public class Service {
    private FamilyTree<Human> familyTree;
    private Savable fileHandler;

    public Service(FamilyTree<Human> familyTree, Savable fileHandler){
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }
    public Service(Savable fileHandler){
        this (new FamilyTree<Human>(), fileHandler);
    }

    // public void addMember(Human human, Human mother, Human father){
    //     familyTree.addMember(human, mother, father);
    // }
    public Human createHuman(String firstName, String lastName, Gender gender, int dayOfBirth, int monthOfBirth, int yearOfBirth){
        return new Human(firstName, lastName, gender, dayOfBirth, monthOfBirth, yearOfBirth);
    }

    public void addMember(Human human, Human mother, Human father){
        familyTree.addMember(human, mother, father);
    }

    public void addMember(String firstName, String lastName, Gender gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, int motherNum, int fatherNum){
        Human mother = null;
        Human father = null;
        if(motherNum != 0){mother =getAllMembers().get(motherNum-1);}
        if(fatherNum != 0){father = getAllMembers().get(fatherNum-1);}
        familyTree.addMember((createHuman(firstName, lastName, gender, dayOfBirth, monthOfBirth, yearOfBirth)), mother, father);
    }

    public List<Human> getAllMembers(){
        return familyTree.getAllMembers();  
    }

    public String getAllMembersAsString(){
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for(Human human: familyTree.getAllMembers()){
            sb.append(counter++);
            sb.append(". ");
            sb.append(human.toString());
            sb.append(" Мать: ");
            if(human.getMother()!=null){
                sb.append(human.getMother().getFirstName());
            }
            else{sb.append("не указана");}

            sb.append(", Отец: ");
            if(human.getFather()!=null){
                sb.append(human.getFather().getFirstName());
            }
            else{sb.append("не указан");}
            sb.append(", Дети: ");
            if(human.getChildren().size()>0){
                for(Human child:human.getChildren()){
                    sb.append(child.getFirstName());
                    sb.append(", ");
                }
            }
            else{sb.append("не указаны");}
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
    
    public boolean save(Serializable serializable, String path){
       return fileHandler.save(serializable, path);
    }

    public FamilyTree<FamilyTreeObject> load(String path){
        return fileHandler.load(path);
    }

}
