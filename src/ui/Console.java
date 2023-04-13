package ui;

import presenter.Presenter;
import tree.FamilyTree;
import tree.Human;


import java.util.*;

public class Console implements View {
    private Presenter presenter;
    private FamilyTree<Human> tree;
    private Scanner scanner;
    private Menu menu;
    private boolean temp;

    public Console(FamilyTree<Human> tree) {
        this.tree = tree;
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        temp = true;
    }

    public void showPerson() {
        System.out.println(tree.toString());
    }

    public void addPerson() {

    }

    public void searchPerson() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println(tree.findHuman(name));
    }

    public void sortName() {
        tree.sortByName();
        System.out.println(tree);
    }

    public void sortBirthdate() {
        tree.sortByBirthDate();
        System.out.println(tree);
    }

    private void exit() {
        temp = false;
    }

    @Override
    public void run() {
        while (temp) {
            menu = new Menu(this);
            while (temp) {
                System.out.println(menu.print());
                System.out.print("Выберите пункт Меню -> ");
                String command = scanner.nextLine();
                if (check(command)) {
                    menu.execute(Integer.parseInt(command));
                } else {
                    System.out.println("Введите число!");
                }
            }
        }
    }

    private boolean check(String check) {
        return check.matches("[0-9]+") && Integer.parseInt(check) <= menu.getSize() && Integer.parseInt(check) > 0;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
