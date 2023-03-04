package HW01.presenter;

import HW01.model.Service;
import HW01.ui.View;

import java.io.IOException;

public class Presenter {
    private View view;

    private Service service = new Service();


    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);

    }

    public void testTree() {
        service.testTree();
    }

    public void loadData() throws IOException, ClassNotFoundException {

        service.loadData();
    }

    public void saveData() throws IOException {
        service.saveData();
    }

    public void addPerson() {
        service.addPerson();
    }

    public void updatePerson() {
        service.updatePerson();
    }

    public void personEnvironment() {
        service.personEnvironment();
    }

    public void searchPerson(String nextLine) {
        service.searchPerson(nextLine);
    }
    public void printTree() {

        service.printTree();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }
}