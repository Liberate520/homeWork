package family_tree.presenter;

import family_tree.model.service.*;
import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.*;
import family_tree.view.*;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter (View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(int id, String name, Gender gender, LocalDate birthDate,
    Human father, Human mother, Human wife, Human husband) {
        service.addHuman(id, name, gender, birthDate, father, mother, wife, husband);
        getInfo();
    }

    public void addHuman(int id, String name, Gender gender, LocalDate birthDate) {
        service.addHuman(id, name, gender, birthDate);
        getInfo();
    }
    public void getInfo() {
        String answer = service.getInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getInfo();
    }

    
    public boolean saveTree(String filePath) {
        if (service.saveTree(filePath)) {
            return true;
        }
        return false;
    }

    public boolean loadTree(String filePath) {
        if (service.loadTree(filePath)) {
            return true;
        }
        return false;
    }

    public boolean loadSampleTree() {
        if (service.loadSampleTree()) {
            return true;
        }
        return false;
    }
}
