package presenter;

import model.Service;
import model.person.Person;
import model.tree.Tree;
import view.ConsoleUI;
import view.PrintData;
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

    public void printLoadData() throws IOException, ClassNotFoundException {
        service.printLoadData();
    }

    public void printSortByName() throws IOException, ClassNotFoundException {
        PrintData.printTree(service.sortByName());
    }

    public void printSortByDOB() throws IOException, ClassNotFoundException {
        PrintData.printTree(service.sortByDOB());
    }

    public void addNewPerson() throws IOException, ClassNotFoundException {
        ConsoleUI console = new ConsoleUI();
        Person person = service.createNewPerson(console.getNewPersonInfo());
        Tree tree = service.file.loadData();
        tree.addPerson(person);
        PrintData.printTree(tree);
        if (console.askToSave()) {
            service.file.saveData(tree);
        }
    }

}
