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

    public boolean addHuman(Human human){
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

    public boolean setDivorce(long id1, long id2){
        if(checkId(id1) && checkId(id2)){
            Human human1 = famTree.getById(id1);
            Human human2 = famTree.getById(id2);
            return setDivorce(human1, human2);
        }
        return false;
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
}
