package presenter;


import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate birthDay, LocalDate deathDay) {
        service.addHuman(name, birthDay, deathDay);
    }

    public void marry(int firstHuman, int secondHuman) {
        service.marry(firstHuman, secondHuman);
    }

    public void addChild(int parent, int child) {
        service.addChild(parent, child);
    }

    public void addParent(int child, int parent) {
        service.addParent(child, parent);
    }

    public void outputInfo() {
        view.printAnswer(service.outputInfo());
    }

    public void sortByName() {
        service.sortByName();
        outputInfo();
    }

    public void sortByBirthDay() {
        service.sortByBirthDay();
        outputInfo();
    }

    public void outputNumHumanList() {
        view.printAnswer(service.outputNumHumanList());
    }

    public int getCountHuman() {
        return service.getCountHuman();
    }

    public void save(String path) {
        service.saveInFile(path);
    }

    public void load(String path) {
        service.loadFromFile(path);
    }
}
