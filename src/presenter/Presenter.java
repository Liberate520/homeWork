package presenter;

import model.Service;
import view.ConsoleUI;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private Service service;
    private View view;
    private ConsoleUI consoleUI;

    public Presenter() {
        this.service = new Service();
    }

    public Service getService() {
        return service;
    }

    public void addHuman(String firstName, String lastName,
                         LocalDate birthDate, LocalDate deathDate,
                         String firstMomName, String lastMomName,
                         String firstDadName, String lastDadName) {
        service.addHuman(firstName, lastName, birthDate, deathDate,
                firstMomName, lastMomName, firstDadName, lastDadName);
        consoleUI.print("Запись добавлена");
    }

    public void getHumanList() {
        service.getHumanList();
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
        service.getHumanByName(firstName, lastName);
    }

    public void getHumanByBirthDate(String year) {
        service.getHumanByBirthDate(year);
    }
}
