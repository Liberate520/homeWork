package ru.gb.family_tree.family_tree.model.Service;

import ru.gb.family_tree.family_tree.model.FamilyTree;
import ru.gb.family_tree.family_tree.model.human.Gender;
import ru.gb.family_tree.family_tree.model.human.Human;
import ru.gb.family_tree.family_tree.model.human.HumanBuilder;
import ru.gb.family_tree.family_tree.model.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private HumanBuilder builder;
    private FamilyTree familytree;

    public Service(){
        builder=new HumanBuilder();
        familytree=new FamilyTree<Human>();
    }
    public void addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = builder.build(name,gender,birthDate);
        familytree.addToFamilyTree(human);
    }
    public void addHuman(String name,Gender gender,LocalDate birthDate,LocalDate deathDate){
        Human human = builder.build(name,gender,birthDate,deathDate);
        familytree.addToFamilyTree(human);
    }
    public void printFamilyTree(){
        familytree.printFamilyTree(familytree);
    }

    public FamilyTree getFamilytree(){return familytree;
    }
    public Human getHumanByID(int ID){
        return (Human) familytree.getPersonByID(ID);
    }
    public void createFamilyConnectionByID(int ID1,int ID2){
        Human humanChild=getHumanByID(ID1);
        Human humanParent=getHumanByID(ID2);
        humanChild.addParent(humanParent);
        humanParent.addChild(humanChild);
    }
    public void save(FamilyTree tree){
            FileHandler fileHandler = new FileHandler();
            fileHandler.save(tree,fileHandler.getPath());
        }
    public void load(){
        FileHandler fileHandler = new FileHandler();
        if (this.familytree!=null){
        familytree =(FamilyTree)fileHandler.load(fileHandler.getPath());}
        else{FamilyTree familyTree =new FamilyTree<Human>();
            familyTree=(FamilyTree)fileHandler.load(fileHandler.getPath());}
    }


    public void sortByAge() {
        familytree.sortByAge();
    }

    public void sortByName() {
        familytree.sortByName();
    }
}
