package Model.Service;

import java.time.LocalDate;

import Model.FamilyTree.FamilyTree;
import Model.FileHandler.FileHandler;
import Model.Human.Human;

public class Service {
    private long humanId;
    private FamilyTree<Human> family;
    private FileHandler fh;

    
    public Service(){
        family = new FamilyTree<>();
        fh = new FileHandler();
    }

    // public void setFamily(FamilyTree<Human> family){
    //     this.family = family;
    // }

    // public FamilyTree<Human> getFamily(){
    //     return family;
    // }

    public FamilyTree<Human> toFamilyTree(Object object){
        return (FamilyTree<Human>)object;
    }

    public void addHuman(String name, String gender,LocalDate dateOfBirth,
    LocalDate dateOfDeath,Human father,Human mother){
        family.addHuman(new Human(name,gender,dateOfBirth,dateOfDeath,father,mother));
    }

    public void addHuman(String name, String gender,LocalDate dateOfBirth,Human father,Human mother){
        family.addHuman(new Human(name,gender,dateOfBirth,father,mother));
    }

    public void addHuman(String name, String gender,LocalDate dateOfBirth){
        family.addHuman(new Human(name,gender,dateOfBirth));
    }

    public String getInfo(){
        return family.getInfo();
    }

    public void save(String path){
        fh.save(family,path);
    }

    public void load(String path){
        family = (FamilyTree<Human>) fh.load(path);
    }

    public void sortByAge(){
        family.sortByAge();
    }

    public void sortByName(){
        family.sortByName();
    }

    public void setWedding(long id1, long id2){
        family.setWedding(family.getById(id1),family.getById(id2));
    }

    public void setDivorse(long id1, long id2){
        family.setDivorse(family.getById(id1), family.getById(id2));
    }

    public void addParents(long childId, long motherId, long fatherId){
        family.getById(childId).addFather(family.getById(fatherId));
        family.getById(childId).addMother(family.getById(motherId));
    }

    public void addChild(long motherId, long fatherId,long childId){
        family.getById(childId).addFather(family.getById(fatherId));
        family.getById(childId).addMother(family.getById(motherId));
        family.getById(motherId).addChild(family.getById(childId));
        family.getById(fatherId).addChild(family.getById(childId));
    }
}
