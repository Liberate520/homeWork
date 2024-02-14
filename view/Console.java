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
        System.out.println("Введите пол человека Female или Male");
        String gender = scanner.nextLine();
        System.out.println("Введите дату рождения 'YYYY-MM-DD' ");
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

    public void SearchBuName() {
        System.out.println("Введите имя:");
        Scanner scan = new Scanner(System.in);
        String st = scan.nextLine();
        presenter.searchByName(st);
    }


    public void finish() {
        System.out.println("До новых встреч");
        work = false;
    }


    public void FamilyNode() {
        System.out.println("Введите родителя");
        String name01 = scanner.nextLine();
        System.out.println("Введите ребенка");
        String name02 = scanner.nextLine();
        presenter.familyNode(name01, name02);
    }

    public void FamilyCollection() {
        presenter.familyCollection();
    }

    public void FamilyTreeEntry() {
        System.out.println("Введите путь к файлу");
        String file = scanner.nextLine();
        presenter.familyTreeEntry(file);
    }

    public void FamilyTreeRead() {
        System.out.println("Введите путь к файлу");
        String file = scanner.nextLine();
        presenter.familyTreeRead(file);
    }


}

