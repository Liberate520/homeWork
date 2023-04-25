package presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Service;
import model.familyTreeApi.Human;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        this.view.setPresenter(this);
    }

    public void add(String firstName, String secondName, LocalDate birthDate, String sex) {
        service.add(firstName, secondName, birthDate, sex);
    }

    public void deleteByName(String firstName, String lastName) {
        service.deleteByName(firstName, lastName);
    }

    public Human getHumanByName(String firstName) {
        return service.getHumanByName(firstName);
    }

    public ArrayList<Human> getHumansList() {
        return service.getHumansList();
    }

    public String printTree() {
        return service.printTree();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void saveFile() throws IOException {
        service.saveFile();
    }

    public void readFile() {
        service.readFile();
    }

    
}
