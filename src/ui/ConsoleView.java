package ui;

import java.util.Scanner;

import mvp.Presenter;

public class ConsoleView implements UserInteraction {
    private Presenter presenter;
    private Scanner scanner;
    private Menu mainMenu;
    private ChoiceChecker choiceChecker;
    public boolean keepRunning;

    public ConsoleView() {
        scanner = new Scanner(System.in);
        mainMenu = new Menu(this);
        choiceChecker = new ChoiceChecker(mainMenu);
        keepRunning = true;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void start() {
        while (keepRunning) {
            showMenu();
            String userChoice = scan();
            if (choiceChecker.isChoiceCorrect(userChoice)) {
                mainMenu.runMenuCommand(Integer.parseInt(userChoice));
            }
        }
    }

    public String scan() {
        return scanner.nextLine();
    }

    public void showMenu() {
        System.out.println(mainMenu.consoleView());
    }

    public void showAllNotes() {
        System.out.println(presenter.allNotes());
    }

    public void inputNote() {
        System.out.println("Выедите новую запись");
        presenter.writeNote(scan());
    }

    public void exit() {
        System.out.println("Работа завершена");
        keepRunning = false;
    }
}
