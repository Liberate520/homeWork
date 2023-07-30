package homeWork.presenter;

import homeWork.model.service.Service;
import homeWork.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, int age) {
        service.addHuman(name, age);
        getHumanInfo();
    }

    public void addChild(String name, int age) {
        service.addHuman(name, age);
        getHumanInfo();
    }

    public void addParent(String name, int age) {
        service.addHuman(name, age);
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