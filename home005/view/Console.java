package view;

import java.util.Scanner;

import presenter.Presenter;

public class Console implements View{
    
    private Presenter presenter;
    private Scanner scanner = new Scanner(System.in);
    private boolean on;
    private Menu menu;
    
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        on = true;
        menu = new Menu(this);
        while (on) {
            printMenu();
            System.out.print("Choose action: ");
            int choice = scanner.nextInt();
            menu.execute(choice - 1);
        }
    }
   
    public void printMenu() {
        System.out.println(menu.printMenu());
    }

    public void addNote() {
        System.out.print("Enter note: ");
        String newNote = scanner.next();
        presenter.addNote(newNote);
    }

    public void printAll() {
        System.out.println(presenter.printAll());
    } 

    public void exit() {
        System.out.println("\nok exit");
        on = false;
    }

    public void editNote() {
        System.out.print("\nEnter note's number: ");
        int index = scanner.nextInt();
        System.out.print("Enter note: ");
        String newNote = scanner.next();
        presenter.editNote(index - 1, newNote);
    }

    public void deleteNote() {
        System.out.print("\nEnter note's number: ");
        int index = scanner.nextInt();
        presenter.deleteNote(index);
    }
}
