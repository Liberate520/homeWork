package ui;


import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View {
    private final Scanner sc;

    public ConsoleUI() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public int choiceMenu() {
        System.out.println("\n======= Главное меню =========");
        System.out.println("\t1. Показать все заметки");
        System.out.println("\t2. Добавить заметку");
        System.out.println("\t3. Удалить заметку");
        System.out.println("\t0. Выход");
        while (true) {
            System.out.print("Введите пункт меню: ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice >= 0 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("\nВведите число от 0 до 3!\n");
                }
            } else {
                System.out.println("\nВведите число от 0 до 3!\n");
                sc.next();
            }
        }
    }


    @Override
    public void printAll(String text) {
        System.out.println(text);
    }

    @Override
    public ArrayList<String> addNote() {
        ArrayList<String> note = new ArrayList<>();
        System.out.println("\nСоздание новой заметки: ");
        sc.nextLine();
        System.out.println("Введите заметку: ");
        String newNote = sc.nextLine();
        note.add(newNote);
        System.out.println("Введите примечание: ");
        String description = sc.nextLine();
        note.add(description);
        return note;
    }

    public void addedNote() {
        System.out.println("\nЗаметка добавлена\n");
    }

    public void removedNote() {
        System.out.println("\nЗаметка удалена\n");
    }

    public int choiceRemove(int size) {
        while (true) {
            System.out.print("\nВведите номер заметки: ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice >= 1 && choice <= size) {
                    return choice;
                } else {
                    System.out.printf("\nВведите число от 1 до %d!\n", size);
                }
            } else {
                System.out.printf("\nВведите число от 1 до %d!\n", size);
                sc.next();
            }
        }
    }


    public void emptyNotebook() {
        System.out.println("\nВ записной книжке нет записей!\n");
    }

}
