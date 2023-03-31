package ui;

import mvp.Presenter;
import ui.menu.MainMenu;
import ui.menu.Menu;

import java.util.Scanner;

public class ConsoleView implements UserInteraction {
    private Presenter presenter;
    private Scanner scanner;
    private Menu mainMenu;
    private ChoiceChecker choiceChecker;
    public boolean keepRunning;

    public ConsoleView() {
        scanner = new Scanner(System.in);
        mainMenu = new MainMenu(this);
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
    public void saveAllNotes() {
        presenter.writeAllNotes();
    }
    public void inputNote() {
        System.out.println("Введите новую запись:");
        presenter.writeNote(scan());
    }
    public void removeNote() {
        System.out.println("Введите номер записи для удаления:");
        String noteID = scan();
        if(choiceChecker.isNumber(noteID)){
            presenter.removeNote(Integer.parseInt(noteID));
        }

    }
    public void replaceNote() {
        System.out.println("Введите номер записи для изменения:");
        String noteID = scan();
        if(choiceChecker.isNumber(noteID)){
            System.out.println("Введите новое содержание записи:");
            String newNote = scan();
            presenter.replaceNote(Integer.parseInt(noteID),newNote);
        }

    }

    public void exit() {
        System.out.println("Работа завершена");
        keepRunning = false;
    }
}
