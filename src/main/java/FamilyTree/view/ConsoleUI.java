package FamilyTree.view;

import FamilyTree.presenter.Presenter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        flag = true;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        System.out.println("Программа для работы с генеалогическим древом");
        while (flag) {
            System.out.println("Выберите действие:\n" +
                    "1. Показать детей\n" +
                    "2. Вывести все дерево\n" +
                    "3. Закончить работу");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showChildren();
                    break;
                case "2":
                    showFamily();
                    break;
                case "3":
                    finish();
                    break;
            }
        }
    }

    private void finish() {
        System.out.println("До свидания!");
        flag = false;
    }

    public void showChildren(){
        System.out.println("Введите имя человека, чьих детей будем искать");
        String name = scanner.nextLine();
        presenter.showChildren(name);
    }

    public void showFamily(){
        presenter.showFamily();
    }
}
