package presenter;

import model.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(String firstName, String lastName,
                         LocalDate birthDate, LocalDate deathDate,
                         String firstMomName, String lastMomName,
                         String firstDadName, String lastDadName) {
        service.addHuman(firstName, lastName, birthDate, deathDate,
                firstMomName, lastMomName, firstDadName, lastDadName);
    }

    public void getHumanList() {
        String humanList = service.getHumanList();
        view.print(humanList);
    }

    public void sortByFirstName() {
        service.sortByFirstName();
    }

    public void sortByLastName() {
        service.sortByLastName();
    }

    public void sortByChildrenCount() {
        service.sortByChildrenCount();
    }

    public void getHumanByName(String firstName, String lastName) {
        String human = service.getHumanByName(firstName, lastName);
        view.print(human);
    }

    public void getHumanByBirthDate(String year) {
        String human = service.getHumanByBirthDate(year);
        view.print(human);
    }
}
