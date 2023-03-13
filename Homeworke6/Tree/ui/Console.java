package ui;

import java.util.Scanner;

import presenter.Presenter;

public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work) {
            visualMenu();
            System.out.print("Input: ");
            String command = scanner.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
                System.out.println();
            } else {
                System.out.println("Oops...");
            }
        }
    }

    private boolean checkInput(String text) {
        return text.matches("[1-9]");
    }

    private void visualMenu() {
        System.out.println("    ***    MENU    ***    ");
        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void finish() {
        System.out.println("   ***   CLOSED   ***    ");
        work = false;
    }

    public void searchByName() {
        System.out.print("Enter name: ");
        presenter.searchByName(scanner.nextLine());
    }

    public void outputAList() {
        presenter.outputAList();
    }

    public void deletePerson() {
        print("Enter name for deletion: ");
        if (presenter.deletePerson(scanner.nextLine())) {
            print("Successfully deleted");
        }
    }

    public void save() {
        presenter.save();
        print("Saved.");
    }

    public void load() {
        presenter.load();
        outputAList();
    }

    public void sortAlfab() {
        presenter.sortAlfab();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void addHuman() {
        try {
            System.out.print("Ввод новых людей должен осуществляться по старшенству.\n"
                    + "Введите имя и фамилию на латиннице: ");
            String fullName = scanner.nextLine();
            System.out.print("Введите год рождения: ");
            String birth = scanner.nextLine();
            System.out.print("Если родители неизвестны то поля необходимо оставить пустыми.\n"
                    + "Введите имя и фамилию матери на латиннице: ");
            String mom = scanner.nextLine();
            System.out.print("Введите имя и фамилию отца на латиннице: ");
            String papa = scanner.nextLine();
            presenter.addHuman(fullName, birth, mom, papa);
            System.out.println("...Ok!");
        } catch (Exception e) {
            System.out.println("Oops!...");
        }
    }
    
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}