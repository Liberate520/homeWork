package presenter;

import familyTree.Service;
import familyTree.enums.Gender;
import familyTree.treeWorkspace.FamilyTree;
import familyTree.treeWorkspace.TreeItem;
import ui.ConsoleUI;

import java.time.LocalDate;

public class Presenter<E extends TreeItem<E>> {
    private ConsoleUI consoleUI;
    private Service<E> service;

    public Presenter(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        service = new Service<>();
    }
    public void addPerson(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
        service.addPerson(name, gender, birthDate, deathDate);
    }
    public void getTreeInfo(){
        service.getInfo();
    }
    public void loadTree(String path){
        service.loadTree(path);
    }
    public void saveTree(String path){
        service.saveTree(path);
    }
    public void sortGender(){
        service.sortByGender();
    }
    public void sortAge(){
        service.sortByAge();
    }
    public void sortName(){
        service.sortByName();
    }
    public void addChild(int parentId,int childId){
        service.findPerson(parentId).addChildren(service.findPerson(childId));
    }
    public void addParent(int childId,int parentId){
        service.findPerson(childId).addParent(service.findPerson(parentId));
    }
}
