package ui;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Здравствуйте!");
        while (work) {
            System.out.println(menu.print());
            String line = scanner.nextLine();
            int numCommand = Integer.parseInt(line);
            menu.execute(numCommand);
        }
    }

    public void addHuman() {
        System.out.println("Введите полное имя:");
        String name = scanner.nextLine();
        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите пол (ж - женский, м - мужской):");
        String gender = scanner.nextLine();
        System.out.println("Введите полное имя матери:");
        String mother = scanner.nextLine();
        System.out.println("Введите полное имя отца:");
        String father = scanner.nextLine();

        presenter.addHuman(name, age, gender, mother, father);

    }

    public void showAllRelatives() {
        presenter.showAllRelatives();
    }

    public void findHumanByName() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println(presenter.findHumanByName(name));
    }

    public void finish() {
        work = false;
    }

    public void showKids() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        presenter.showKids(name);
    }

    public void findSiblings() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        presenter.findSiblings(name);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
