package view;

import presenter.Presenter;

import java.util.Scanner;

/*
Класс для работы с консолью.
 */
public class Dispatcher implements View {
    private Presenter presenter;

    private final Scanner input = new Scanner(System.in);

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void start() {
        System.out.println("Type your commands:");
        while (true) {
            String command = scan();
            presenter.getCommand(command);
        }
    }

    @Override
    public void print(String data) {
        System.out.println(data);
    }

    public String scan() {
        return input.nextLine();
    }
}
