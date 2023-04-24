package src.ui;

import java.util.Scanner;

import src.presenter.Presenter;

public class ConsoleUi implements View {
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUi(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        String name = scan();
        presenter.onClick(name);
    }

    private String scan() {
        System.out.println("Введите имя: ");
        return scanner.nextLine();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
