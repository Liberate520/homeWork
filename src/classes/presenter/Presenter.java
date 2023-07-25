package classes.presenter;

import classes.model.service.Service;
import classes.view.ConsoleUI;

import javax.swing.text.View;

public class Presenter {
    private ConsoleUI view;
    private Service service;

    public Presenter(ConsoleUI view) {
        this.view = view;
        service = new Service();
    }

    public void testInput() {
        Service.testInput();
    }

    public void saveTree() {
        Service.saveTree();
    }

    public void readTree() {
        Service.readTree();
    }

    public void getTreeInfo() {
        Service.getTreeInfo();
    }

    public void sortTreeByName() {
        Service.sortTreeByName();
        ;
    }

    public void sortTreeById() {
        Service.sortTreeById();
    }

    public void sortTreeByBrithDate() {
        Service.sortTreeByBrithDate();
    }
}
