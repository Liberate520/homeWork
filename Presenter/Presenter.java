package Presenter;

import Model.*;
import Model.Service.Service;
import View.*;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, String familyStatus) {
        service.addHuman(name, gender, dateOfBirth, dateOfDeath, familyStatus);
        //TODO какой-то ответ
    }

    public void getFamilyInfo() {
        String info = service.getFamilyInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void saveFile() {
        service.saveFile();
    }

    public void load() {
        service.loadFile();
    }
}