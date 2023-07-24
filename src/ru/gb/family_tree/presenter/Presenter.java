package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.Service;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String fullName, Gender gender, LocalDate dateOfBirth/*, LocalDate dateOfDeath*/) {
        service.addHuman(fullName ,gender, dateOfBirth/*, dateOfDeath*/);
        getInfo();
    }

    public void getInfo() {
        String info = service.getInfo();
        view.exitAnswer(info);
    }

    public void sortByFullName() {
        service.sortByFullName();
        getInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getInfo();
    }

    public void saveFile() {
        service.saveFile();
    }

    public void readFile() {
        service.readFile();
        getInfo();
    }
}
