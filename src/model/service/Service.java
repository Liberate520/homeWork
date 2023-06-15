package model.service;

import java.io.IOException;

public class Service {
    private FileService fileService;
    private PrintService printService;

    public Service() {
        fileService = new FileService();
        printService = new PrintService();
    }

    public void loadData() throws IOException, ClassNotFoundException {
        fileService.loadData();
    }

    public void saveData() throws IOException {
        fileService.saveData();
    }

    public void printSortByName() {
        printService.printSortByName();
    }

    public void printSortByDOB() {
        printService.printSortByDOB();
    }
}
