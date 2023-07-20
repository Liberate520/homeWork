package Homework.model.service;

import Homework.model.Human.Gender;
import Homework.model.Human.Human;
import Homework.model.Tree.FamilyTree;
import Homework.model.Tree.FileMethods.FileMethods;


import java.time.LocalDate;

public class Service {

    private FamilyTree familyTree;
    private FileMethods fileMethods;

    public Service() { familyTree = new FamilyTree<>();
        fileMethods = new FileMethods();
    }

    public void addHuman(String name, Gender gender, LocalDate birth, LocalDate death, Human father, Human mother){
        Human human = new Human(name, gender, birth, death, father, mother);
        familyTree.addHuman(human);
    }

    public Human addParents(String parent){
        Human findHuman = (Human) familyTree.getByName(parent);
        if(findHuman != null) {
            familyTree.addToParents(findHuman);
        }
        else {
            System.out.println("Нет сведений о таком человеке.");
        }
        return findHuman;
    }

    public void addChildren(Human human, Human child){
        if(child.getParents().contains(human)){
            for(Human parent: child.getParents()){
                familyTree.addToChild(human, child);
            }
        }


    }

    public String getHumanInfo(){return familyTree.getHumanInfo();}

    public void sortByName() { familyTree.sortByName(); }

    public void sortByAge() { familyTree.sortByAge(); }

    public void sortByChildren() { familyTree.sortByChildren();}

    public void saveINFile(){
        fileMethods.saveAllInFile(familyTree, "src/Homework/Result.out");
    }

    public void readFile(){
        familyTree = (FamilyTree)fileMethods.read("src/Homework/Result.out");
        System.out.println(familyTree.getHumanInfo());
    }
}
