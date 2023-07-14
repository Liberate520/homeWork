package faminly_tree.presenter;

import faminly_tree.model.human.Gender;
import faminly_tree.model.service.Service;
import faminly_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
    public void addHuman(String name, Gender gender, LocalDate date) {
        service.addHuman(name, gender, date);
    }
    public void sortByAge() {
        service.sortByAge();
    }
    public void sortByName() {
        service.sortByName();
    }
    public void sortByID(){
        service.sortByID();
    }
    public void showAllTree() {
        service.showAllTree();
    }
    public boolean connection(int parentID, int childID) {
        return service.connection(parentID, childID);
    }
    public boolean save(String path) {
        return service.save(path);
    }
    public void downland(String path) {
        service.dowland(path);
    }
    public void nextOfKin(int humanID) {
        service.nextOfKin(humanID);
    }
    public int treeIsEmpty(){
        return service.treeIsEmpty();
    }
}
