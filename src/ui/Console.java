package ui;

import presenter.Presenter;
import model.tree.FamilyTree;
import model.tree.Human;

import java.util.*;

public class Console implements View {
    private Presenter presenter;
    private FamilyTree<Human> tree;
    private Scanner scanner;
    private Menu menu;
    private boolean temp;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        temp = true;
    }

    public void showPerson() {
        presenter.toString();
    }

    public void addPerson() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите пол человека");
        String genger = scanner.nextLine();
        System.out.println("Введите дату рождения человека");
        String birthDate = scanner.nextLine();
        System.out.println("Введите дату смерти человека");
        String deathDate = scanner.nextLine();
        System.out.println("Введите имя отца человека");
        String father = scanner.nextLine();
        System.out.println("Введите имя матери человека");
        String mother = scanner.nextLine();
        presenter.addHuman(name, genger, birthDate, deathDate, father, mother);
    }
    public void humanList(){
        presenter.humanList();
    }

    public void searchPerson() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        presenter.findHuman(name);
    }

    public void sortName() {
        presenter.sortByName();
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
