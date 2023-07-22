package presenter;

import java.time.LocalDate;

import familly_api.service.Service;
import ui.ConsoleView;

public class Presenter {
    ConsoleView view;
    Service service;

    public Presenter(ConsoleView consoleView) {
        this.view = consoleView;
        service = new Service();
    }

    public void creatHuman(String firstName, String lastName, String middleName, LocalDate born, LocalDate death,
            String gender) {
        service.creatHuman(firstName, lastName, middleName, born, death, gender);
        getHumanList();
    }

    public void getHumanList() {
        String info = service.getHumanList();
        view.printAnswer(info);
    }

    public void getNode(int numberHuman) {
        service.getNode(numberHuman);
    }

    public void addChild(int numberChild, int numberParent) {
        if (numberChild == numberParent) {
            view.printAnswer("Человек не может быть сам себе родителем и ребенком.");
        } else {
            service.addChild(numberChild, numberParent);
        }
    }

    public void searchName(String firstName) {
        String info = service.searchName(firstName);
        view.printAnswer(info);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void saveFile(String fileName) {
        service.saveFamily(fileName);
    }

    public void loadFile(String fileName) {
        service.loadFamily(fileName);
    }

    public int getSizeListHuman() {
        return service.getSize();
    }
}
