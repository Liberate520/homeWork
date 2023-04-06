package view;

import java.util.Scanner;

import presenter.Presenter;

public class Menu implements View{

    private Presenter presenter;
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void start() {
        int choise = getChoise();
        presenter.action(choise);
    }

    private int getChoise() {
        System.out.println("Choose action:\n1. Add note\n2. Show all notes\n3. Exit");
        return scanner.nextInt();
    }

    public String newNote() {
        System.out.println("Enter note: ");
        return scanner.next();
    }
}
