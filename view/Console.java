package view;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {

    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;

    public Console() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            menu.execute(choice);
        }
    }

    public void AddHuman() {
        getHumanList();
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите пол человека");
        String gender = scanner.nextLine();
        System.out.println("Введите возраст человека");
        String age = scanner.nextLine();
        presenter.addHumans(name, gender, age);
    }

    public void getHumanList() {
        presenter.getHumanList();
    }


    public void GetSortByName() {
        presenter.sortByName();
    }
    public void GetSortByAge() {
        presenter.sortByAge();
    }

    public void SearchBuName(){
        presenter.searchByName();
    }


    public void finish() {
        System.out.println("До новых встреч");
        work = false;
    }
}

