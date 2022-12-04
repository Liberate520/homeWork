package View;

import Presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner sc;

    public ConsoleUI() {
        sc = new Scanner(System.in);
    }

    @Override
    public void start() {
        System.out.println("Выберите нужное действие:" + "\n" +
                "1. Просмотр всех людей " + "\n" +
                "2. Просмотр одного человека дерева " + "\n" +
                "3. Добавление человека " + "\n" +
                "4. Создание связи" + "\n" +
                "Для выхода укажите 0");
        int num = sc.nextInt();
        while (!(num == 0)) {
            presenter.onClick(num);
        }

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
