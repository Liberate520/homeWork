package ui;


import presenter.Presenter;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View {
    private final Scanner sc = new Scanner(System.in);
    private Presenter presenter;

    private boolean workNotebook;
    private MenuConsole menu;

    private final Validator validator = new Validator();


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onClick() {
        workNotebook = true;
        menu = new MenuConsole(this);
        do {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            String text = sc.next();
            int choice = validator.checkInput(text, menu.getSizeMenu());
            if (choice != -1) {
                menu.execute(choice - 1);
            } else {
                System.out.printf("\nВведите число от 1 до %d!\n", menu.getSizeMenu());
            }
        } while (workNotebook);
    }


    public void printMenu() {
        System.out.println(menu.printMenu());
    }

    public void finish() {
        System.out.println("\nЗавершение работы");
        workNotebook = false;
    }


    public void addNote() {
        ArrayList<String> note = new ArrayList<>();
        System.out.println("\nСоздание новой заметки: ");
        sc.nextLine();
        System.out.print("Введите заметку: ");
        String newNote = sc.nextLine();
        note.add(newNote);
        System.out.print("Введите примечание: ");
        String description = sc.nextLine();
        note.add(description);
        presenter.addNote(note);
        System.out.println("\nЗаметка добавлена\n");
    }

    public void changeNote() {
        if (presenter.isFull()) {
            ArrayList<String> note = new ArrayList<>();
            while (true) {
                System.out.print("\nВведите номер заметки: ");
                String text = sc.next();
                int choice = validator.checkInput(text, presenter.getSizeNotebook());
                if (choice != -1) {
                    sc.nextLine();
                    System.out.print("Обновите заметку: ");
                    String newNote = sc.nextLine();
                    note.add(newNote);
                    System.out.print("Обновите примечание: ");
                    String description = sc.nextLine();
                    note.add(description);
                    presenter.changeNote(note, choice - 1);
                    System.out.println("Заметка изменена");
                    break;
                } else {
                    System.out.printf("\nВведите число от 1 до %d!\n", presenter.getSizeNotebook());
                }
            }
        } else System.out.println("\nВ записной книжке нет записей!\n");
    }

    public void removeNote() {
        if (presenter.isFull()) {
            while (true) {
                System.out.print("\nВведите номер заметки: ");
                String text = sc.next();
                int choice = validator.checkInput(text, presenter.getSizeNotebook());
                if (choice != -1) {
                    presenter.removeNote(choice);
                    System.out.println("\nЗаметка удалена\n");
                    break;
                } else {
                    System.out.printf("\nВведите число от 1 до %d!\n", presenter.getSizeNotebook());
                }
            }
        } else System.out.println("\nВ записной книжке нет записей!\n");
    }

    public void printAll() {
        if (presenter.isFull()) {
            System.out.println(presenter.printAll());
        } else System.out.println("\nВ записной книжке нет записей!\n");
    }

}
