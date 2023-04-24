package src.ui;
import java.util.Scanner;

import src.presenter.Presenter;

public class ConsoleUi implements View {
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (true) {
            Integer key = scan();
            switch (key) {
                case 1:
                    presenter.onClick1();
                    break;
                case 2:
                    String name = scanName();
                    presenter.onClick2(name);
                    break;
                    case 3:
                    name = scanName();
                    System.out.println(presenter.onClick3(name));
                    break;
                    case 4:
                    System.out.println(presenter.onClick4());
                default:
                    break;
            }

        }
    }

    private int scan() {
        System.out.println(
                "Выберите цифру соответствующую нужному пункту: \n1) Вывести все имена из древа\n2) Добавить человека\n3) Поиск человека\n4) Вывести всю информацию по дереву");
        return scanner.nextInt();
    }

    private String scanName() {
        System.out.println("Введите имя человека: ");
        return scanner.next();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
