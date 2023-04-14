package ui;

import java.io.IOException;
import java.util.Scanner;

import model.service.Service;
import presenter.Presenter;

public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work = true;

    public Console() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println("1-addPerson\n" +
                    "2-serch\n" +
                    "3-sort\n" +
                    "4-save File\n" +
                    "5-read File\n" +
                    "6-print\n" +
                    "7-Завершение работы\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addRecord();
                    break;
                case "2":
                    viewAll();
                    break;
                case "3":
                    sortFree();
                    break;
                case "4":
                    saveTree();
                    break;
                case "5":
                    readTree();
                    break;
                case "6":
                    printTree();
                    break;
                case "7":
                    exit();
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }

    private void exit() {
        System.out.println("Работа завершена");
        scanner.close();
        work = false;
    }

    @Override
    public void serPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void viewAll() {
        System.out.println("Введите name");
        String all = scanner.nextLine();
        presenter.getRecords(all);
    }

    private void addRecord() {
        System.out.println("Введите name:");
        String name = scanner.nextLine();
        System.out.println("Введите father:");
        String father = scanner.nextLine();
        System.out.println("Введите mother:");
        String mother = scanner.nextLine();
        System.out.println("Введите year of birth:");
        String year = scanner.nextLine();
        
        presenter.addRecord(name, father, mother, year);

    }

    private void saveTree() {
        presenter.getSaveTree();
        ;
    }

    private void readTree() {
        presenter.getReadTree();
    }

    private void sortFree() {
        System.out.println("1-sotrByName\n" +
                "2-sortBirthDate");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                sortByName();
                break;
            case "2":
                sortBirthDate();
                break;
        }
    }

    private void sortByName() {
        presenter.getSorterByName();
    }

    private void sortBirthDate() {
        presenter.getSortBirthDate();
    }

    private void printTree() {
        presenter.getPrint();
    }

}
