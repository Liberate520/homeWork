package ru.gb.family_tree.family_tree.model.Service;

import ru.gb.family_tree.family_tree.model.FamilyTree;
import ru.gb.family_tree.family_tree.model.comparator.FamilyComparatorByName;
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
        familytree=new FamilyTree<>();
    }
    public void addHuman(String name, Gender gender, LocalDate birthDate, Human mother, Human father){
        Human human = builder.build(name,gender,birthDate,mother,father);
        familytree.addToFamilyTree(human);
    }
    public void addHuman(String name,Gender gender,LocalDate birthDate,LocalDate deathDate,Human mother,Human father){
        Human human = builder.build(name,gender,birthDate,deathDate,mother,father);
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
    public void SetParentByID(int ID1,int ID2){
        Human human=getHumanByID(ID1);
        human.addParent(getHumanByID(ID2));
    }
    public void SetChildByID(int ID1,int ID2){
        Human human=getHumanByID(ID1);
        human.addChild(getHumanByID(ID2));
    }
    public void save(FamilyTree tree){
            FileHandler fileHandler = new FileHandler();
            fileHandler.save(tree,fileHandler.getPath());
        }
    public void load(){
        FileHandler fileHandler = new FileHandler();
        if (this.familytree!=null){
        familytree =(FamilyTree)fileHandler.load(fileHandler.getPath());}
        else{FamilyTree familyTree =new FamilyTree();
            familyTree=(FamilyTree)fileHandler.load(fileHandler.getPath());}
    }
}
