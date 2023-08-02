package homeWork.presenter;

import java.time.LocalDate;

import homeWork.model.fileHandler.Writable;
import homeWork.model.human.gender.Gender;
import homeWork.model.service.Service;
import homeWork.view.View;

public class Presenter {
    private View view;
    private Service service;
    private int id;
    Writable wr;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birthdate, int age, int id) {
        service.addHuman(name, gender, birthdate, age, id);
        getHumanInfo();
    }

    public void addChild(String name, Gender gender, LocalDate birthdate, int age, int id) {
        service.addHuman(name, null, null, age, id);
        getHumanInfo();
    }

    public void addParent(String name, Gender gender, LocalDate birthdate, int age, int id) {
        service.addHuman(name, null, null, age, id);
        getHumanInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanInfo();
    }

    public void getHumanInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void saveInFile() {
        service.saveInFile();

    }

    public void ReadFromFile() {
        service.readFromFile();
    }

}