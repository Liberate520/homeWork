package presenter;

import model.Service;

import java.io.IOException;

public class Presenter {
    private Service service;
    public void loadData() throws IOException, ClassNotFoundException {
        service.loadData();
    }

    public void saveData() throws IOException {
        service.saveData();
    }

    public void printSortByName() {
        service.printSortByName();
    }

    public void printSortByDOB() {
        service.printSortByDOB();
    }

}
