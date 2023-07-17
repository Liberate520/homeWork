package family_tree.presenter;

import family_tree.model.Gender;
import family_tree.model.ItemFamilyTree;
import family_tree.model.ServiceFamilyTree;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private ServiceFamilyTree service;

    public Presenter(View view) {
        this.view = view;
        service = new ServiceFamilyTree();
    }

    public void addHuman(String name, LocalDate dateBirth, Gender gender) {
        service.addItem(name, dateBirth, gender);
    }

    public boolean addChild(int idParent, int idChild) {
        return service.addChild(idParent, idChild);
    }

    public boolean addMarriage(LocalDate date, int idWife, int idHusband) {
        return service.addMarriage(date, idWife, idHusband);
    }

    public boolean stopMarriage(LocalDate dateMarriage, int idMarriage) {
        return service.stopMarriageById(idMarriage, dateMarriage);
    }

    public void sortHumansByAge() {
        service.sortItemsByAge();
    }
    public void sortHumansByName() {
        service.sortItemsByName();
    }

    public void printInfoTree() {
        view.print(service.getInfoAll());
    }

    public void printLastHuman() {
        view.print(service.getInfoLastItem());
    }
    public void printLastMarriage() {
        view.print(service.getInfoLastMarriage());
    }
    public boolean saveToFile(String path){
        return service.saveToFile(path);
    }
    public boolean loadFromFile(String path){
        return service.loadFromFile(path);
    }
}
