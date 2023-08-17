package ru.gb.fam_tree.model.family_tree.service;

import ru.gb.fam_tree.model.family_tree.FamilyTree;
import ru.gb.fam_tree.model.family_tree.all_tree_items.human.Gender;
import ru.gb.fam_tree.model.family_tree.all_tree_items.human.Human;
import ru.gb.fam_tree.model.file_handler.FileHandler;
import ru.gb.fam_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Service {
    private FamilyTree<Human> famTree;
    private FileHandler fileHandler;

    public Service(){
        famTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public boolean addHuman(String name, Gender gender, LocalDate birthdate){
        Human human = new Human(name, gender, birthdate);
        return famTree.add(human);
    }

    public List<Human> getSiblibngs(long id){
        return famTree.getSiblings(id);
    }

    public List<Human> getByName(String name){
        return famTree.getByName(name);
    }

    public boolean setWedding(Human human1, Human human2){
        return famTree.setWedding(human1, human2);
    }

    public boolean setWedding(long id1, long id2){
        if(checkId(id1) && checkId(id2)){
            Human human1 = famTree.getById(id1);
            Human human2 = famTree.getById(id2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(Human human1, Human human2){
        return setDivorce(human1, human2);
    }

    public void setDivorce(long id1, long id2){
        if(checkId(id1) && checkId(id2)){
            Human human1 = famTree.getById(id1);
            Human human2 = famTree.getById(id2);
            famTree.setDivorce(human1, human2);
        }
    }

    public boolean remove(long id){
        return famTree.remove(id);
    }

    public boolean checkId(long id){
        return famTree.checkId(id);
    }

    public Human getById(long id){
        return famTree.getById(id);
    }

    public void sortByName(){
        famTree.sortByName();
    }

    public void sortByAge(){
        famTree.sortByAge();
    }

    public void getHumansInfo(){
        System.out.println(famTree);;
    }

    public void LoadFormFile(String path){
        fileHandler.read(path);
    }

    public void SaveToFile(String path){
        fileHandler.save(famTree, path);
    }

    public void setGender(long id, Gender gender){
        Human human = getById(id);
        human.setGender(gender);
    }

    public void setBirthDate(long id, LocalDate birthDate){
        Human human = getById(id);
        human.setBirthDate(birthDate);
    }

    public void setDeathDate(long id, LocalDate deathDate){
        Human human = getById(id);
        human.setDeathDate(deathDate);
    }

    public void setFather(long idChild, long idFather){
        Human child = getById(idChild);
        Human father = getById(idFather);
        famTree.setParent(child,father);
    }

    public void setMother(long idChild, long idMother){
        Human child = getById(idChild);
        Human mother = getById(idMother);
        famTree.setParent(child, mother);
    }

    public void setChild(long idParent, long idChild){
        Human parent = getById(idParent);
        Human child = getById(idChild);
        famTree.setParent(child, parent);
    }

    public void setName(long id, String newName){
        Human human = getById(id);
        human.setName(newName);
    }

    public void getName(long id){
        Human human = getById(id);
        human.getName();
    }

    public long getLastId(){
        return famTree.getObjectId();
    }

    public LocalDate getBirthDate(long id){
        Human human = getById(id);
        return human.getBirthDate();
    }

    public Gender getGender(long id){
        Human human = getById(id);
        return human.getGender();
    }

    public Human getMother(long id){
        Human human = getById(id);
        return human.getMother();
    }

    public Human getFather(long id){
        Human human = getById(id);
        return human.getFather();
    }

    public Human getSpouce(long id){
        Human human = getById(id);
        return human.getSpouse();
    }

    public Human getHuman(long id){
        return getById(id);
    }
}
