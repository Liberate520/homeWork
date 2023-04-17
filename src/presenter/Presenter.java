package presenter;

import java.time.LocalDate;

import model.Service;
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

    public void getHumanByName(String firstName) {
        service.getHumanByName(firstName);
    }

    public void printTree() {
        service.printTree();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void sortByName() {
        service.sortByName();
    }

    
}
