package view;

import Presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    private final Presenter presenter;
    private final MainMenu mainMenu;
    private final Scanner scanner;
    private boolean flag;

    public Console() {
        this.mainMenu = new MainMenu(this);
        this.scanner = new Scanner(System.in);
        this.flag = true;
        this.presenter = new Presenter(this);
    }

    @Override
    public void changeFlag() {
        this.flag = !this.flag;
    }

    @Override
    public void start() {
        System.out.println("Hello: ");
        while (flag) {
                this.mainMenu.printMenu();
                this.mainMenu.execute(getAnswer());
            }
        }

    private Integer getAnswer() {
        String answer = scanner.nextLine();
        int size = this.mainMenu.getNumberOfCommands();
        while (!checkAnswer(answer)) {
            System.out.println("wrong command, enter number!!!");
            answer = scanner.nextLine();
        }
        return Integer.parseInt(answer);
    }

    private boolean checkAnswer(String answer) {
        if (answer.matches("[0-9]+")){
            return true;
        }
        return false;
    }

    public Presenter getPresenter() {
        return this.presenter;
    }
}
