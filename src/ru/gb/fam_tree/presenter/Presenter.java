package ru.gb.fam_tree.presenter;

import ru.gb.fam_tree.model.family_tree.FamilyTree;
import ru.gb.fam_tree.model.family_tree.all_tree_items.human.Gender;
import ru.gb.fam_tree.model.family_tree.all_tree_items.human.Human;
import ru.gb.fam_tree.model.family_tree.service.Service;
import ru.gb.fam_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birthdate){
        service.addHuman(name, gender,birthdate);
    }

    public void getHumansInfo(){
        service.getHumansInfo();
    }

    public void sortByName(){
        service.sortByName();
        getHumansInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getHumansInfo();
    }

    public void LoadFromFile(String path){
        service.LoadFormFile(path);
        getHumansInfo();
    }

    public void SaveToFile(String path){
        service.SaveToFile(path);
    }

    public void setName(long id, String newName){
        service.setName(id, newName);
    }

    public long getLastid(){
        return service.getLastId();
    }

    public void setGender(long id, Gender gender){
        service.setGender(id,gender);
    }

    public void setBirthDate(long id, LocalDate bdate){
        service.setBirthDate(id, bdate);
    }

    public void setDeathDate(long id, LocalDate ddate){
        service.setDeathDate(id,ddate);
    }

    public void setMother(long idChild, long idMother){
        service.setMother(idChild, idMother);
    }

    public void setFather(long idChild, long idFather){
        service.setFather(idChild, idFather);
    }

    public void setChild(long idParent, long idChild){
        service.setChild(idParent, idChild);
    }

    public void setWedding(long id1, long id2){
        service.setWedding(id1,id2);
    }

    public void setDivorce(long id1, long id2){
        service.setDivorce(id1, id2);
    }

    public LocalDate getBirthDate(long id){
        return service.getBirthDate(id);
    }

    public Gender getGender(long id){
        return service.getGender(id);
    }

    public Human getMother(long id){
        return service.getMother(id);
    }

    public Human getFather(long id){
        return service.getFather(id);
    }

    public Human getSpouce(long id){
        return service.getSpouce(id);
    }

    public Human getHuman(long id){
        return service.getHuman(id);
    }
}
