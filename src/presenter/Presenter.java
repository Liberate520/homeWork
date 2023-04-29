package presenter;

import model.Human;
import model.Service;
import view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public Human CreateHuman() {
        return service.CreateHuman();
    }

    public void getHumanByName() {
        service.getHumanByName();
    }

    public void print() {
        service.print();
    }

    public void createTree() {
        service.createTree();
    }

    public void printChildren() {
        service.printChildren();
    }

    public void writeInFile() throws IOException {
        service.writeInFile();
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        service.readFromFile();
    }

    public void sortByParameter(int num) {
        service.sortByParameter(num);
    }

    public void addHuman(Human human) {
        service.addHuman(human);
        System.out.printf("Вы успешно добавили в древо нового родственника:\n  %s\n", human.toString());
    }
}