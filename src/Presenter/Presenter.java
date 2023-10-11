package Presenter;

import Model.obj.Gender;
import Model.service.Service;
import View.ConsoleUI;

import java.time.LocalDate;

public class Presenter {

    private ConsoleUI view;
    private Service service;

    public Presenter(ConsoleUI view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String fstName, String lstName, LocalDate bornDate, LocalDate deathDate,
                         Gender gender) {
        service.addHuman(fstName,lstName,bornDate,deathDate,gender);
    }

    public void addHumanParent(int cId, int pId){
        service.addHumanParent(cId,pId);
    }

    public void getHumanList(){
        String answer = service.getInfo();
        view.printAnswer(answer);
    }

    public void sortByFstName() {
        service.sortByFstName();
        getHumanList();
    }

    public void sortByLstName() {
        service.sortByLstName();
        getHumanList();
    }

    public void sortByBornDateName() {
        service.sortByBornDate();
        getHumanList();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanList();
    }

    public void saveTree() {
        service.saveTree();
    }

    public void readTree() {
        service.readTree();
    }
}
