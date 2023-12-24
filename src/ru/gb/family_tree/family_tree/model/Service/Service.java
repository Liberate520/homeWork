package ru.gb.family_tree.family_tree.model.Service;

import ru.gb.family_tree.family_tree.model.FamilyTree;
import ru.gb.family_tree.family_tree.model.human.Gender;
import ru.gb.family_tree.family_tree.model.human.Human;
import ru.gb.family_tree.family_tree.model.human.HumanBuilder;
import ru.gb.family_tree.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.family_tree.model.writer.SaveAndLoad;

import java.time.LocalDate;

public class Service {
    private HumanBuilder builder;
    private FamilyTree familytree;
    private SaveAndLoad filehandler;

    public Service(){
        builder=new HumanBuilder();
        familytree=new FamilyTree<Human>();
        this.filehandler=new FileHandler();
    }
    public void addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = builder.build(name,gender,birthDate);
        familytree.addToFamilyTree(human);
    }
    public void addHuman(String name,Gender gender,LocalDate birthDate,LocalDate deathDate){
        Human human = builder.build(name,gender,birthDate,deathDate);
        familytree.addToFamilyTree(human);
    }
    public String getFamilyTree(){
        return familytree.getFamilyTree();
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
         filehandler.save(tree,filehandler.getPath());
        }
    public void load(){
        if (this.familytree!=null){
        familytree =(FamilyTree)filehandler.load(filehandler.getPath());}
        else{FamilyTree familyTree =new FamilyTree<Human>();
            familyTree=(FamilyTree)filehandler.load(filehandler.getPath());}
    }


    public void sortByAge() {
        familytree.sortByAge();
    }

    public void sortByName() {
        familytree.sortByName();
    }
}
