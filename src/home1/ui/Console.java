package home1.ui;

import java.util.Scanner;

import home1.model.FamilyTree;
import home1.model.Human;
import home1.presenter.Presenter;

public class Console implements View {
    private Scanner scan;
    private Presenter presenter;
    private Menu menu;
    private boolean go;

    @Override
    public void start() {
        scan = new Scanner(System.in);
        menu = new Menu(this);
        go = true;
        while (go) {
            header();
            menuUi();
            System.out.print("Выберите пункт Меню -> ");
            String command = scan.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("Введите число!");
            }
        }
    }

    private void header() {
        System.out.println("\n" +
                " В данной программе доступны поиск, \n добавление и вывод семейного древа");
    }

    private void menuUi() {
        System.out.println(menu.printMenu());
    }

    public void addHumanNew() {
        presenter.addHumanNew();
    }

    public void end() {
        go = false;
        System.out.println("Спасибо что пользуетесь нашим сервисом :D");
    }

    public void familyPrint() {
        presenter.familyPrint();
    }

    public void humanSearch() {
        presenter.humanSearch();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String scan() {
        scan = new Scanner(System.in, "Cp866");
        return scan.nextLine();
    }

    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void print(Human human) {
        System.out.println(human);
    }

    @Override
    public void print(FamilyTree<Human> FamilyTree) {
        System.out.println(FamilyTree);
    }
}
