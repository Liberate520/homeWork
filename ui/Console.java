package ui;

import java.io.IOException;
import java.util.Scanner;

import model.service.Service;
import presenter.Presenter;

public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work = true;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        
    }


    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
           System.out.println(menu.printMenu()); 
           int number = Integer.parseInt(scanner.nextLine()) ;
           menu.execute(number);

        }
    }

    public void exit() {
        System.out.println("Работа завершена");
        scanner.close();
        work = false;
    }

    @Override
    public void serPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void search() {
        System.out.println("Введите name");
        String all = scanner.nextLine();
        presenter.getRecords(all);

    }

    public void addRecord() {
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

    public void saveTree() {
        presenter.getSaveTree();
        ;
    }

    public void readTree() {
        presenter.getReadTree();
    }

    

    public void sortByName() {
        presenter.getSorterByName();
    }

    public void sortBirthDate() {
        presenter.getSortBirthDate();
    }

    public void printTree() {
        presenter.getPrint();
    }

}
