package model.service;

import model.family_tree.FamilyTree;
import model.file_handler.FileHandler;
import model.file_handler.Writable;
import model.human.Gender;
import model.human.Human;
import model.human.HumanBuilder;

import java.time.LocalDate;

public class Service{
    public FamilyTree<Human> familyTree;
    private Writable writable;



    public Service(Writable writable) {
        this.familyTree = new FamilyTree<>();
        this.writable = writable;
    }

    public void addHumanInTree(String name, Gender gender,LocalDate localDate){
        HumanBuilder humanBuilder1 = new HumanBuilder();
        familyTree.addHumanInTree(humanBuilder1.build(name, gender, localDate));
    }

    public void addChildren(String parants,String name, Gender gender, LocalDate localDate){
        for (Human human: familyTree){
            if(human.getName().equals(parants)){
                human.addChildren(name,gender,localDate);
            }
        }
    }

    public String printAllTree(){
        return familyTree.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }


    public void save(){
        writable.save(familyTree);
    }

    public FamilyTree<Human> load() {
        String filePath = "src/model/file_handler/tree.txt";
        familyTree = (FamilyTree<Human>) writable.read(filePath);
        return familyTree;
    }
}
