package viewer;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        System.out.println("Здравствуйте!");

    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
