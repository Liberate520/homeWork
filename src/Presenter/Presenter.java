package Presenter;

import java.io.Serializable;
import java.time.LocalDate;

import Model.FamilyTree.FamilyTree;
import Model.Human.Human;
import Model.Service.Service;
import View.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    // public void addHuman(String name, String gender,LocalDate dateOfBirth,
    // LocalDate dateOfDeath,Human father,Human mother){
    //     service.addHuman(name, gender, dateOfBirth,dateOfDeath,father,mother);
    //     getInfo();
    // }

    // public void addHuman(String name, String gender,LocalDate dateOfBirth,Human father,Human mother){
    //     service.addHuman(name, gender, dateOfBirth,father,mother);
    //     getInfo();
    // }

    public void addHuman(String name, String gender,LocalDate dateOfBirth){
        service.addHuman(name, gender, dateOfBirth);
        getInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getInfo();
    }
    
    public void sortByName(){
        service.sortByName();
        getInfo();
    }

    public void getInfo(){
        view.printAnswer(service.getInfo());
    }

    public FamilyTree<Human> getFamily(){
        return service.getFamily();
    }

    public void setFamily(FamilyTree<Human> family){
        service.setFamily(family);
    }

    public void save(Serializable serializable, String path){
        serializable = service.getFamily();
        service.save(serializable, path);
    }

    public Object load(String path){
       return service.load(path);
    }

    public FamilyTree<Human> toFamilyTree(Object object){
        return service.toFamilyTree(object);
    }

    public void setWedding(long id1, long id2){
        service.setWedding(id1, id2);
    }

    public void setDivorse(long id, long id2){
        service.setDivorse(id, id2);
    }

    public void addParents(long childId, long motherId, long fatherId){
        service.addParents(childId, motherId, fatherId);
    }

    public void addChild(long motherId, long fatherId,long childId){
        service.addChild(motherId, fatherId, childId);
    }
}
