package Homework25_2.UI;

import java.util.ArrayList;
import java.util.Scanner;

public class Console implements View {
    private Menu menu;
    private final Scanner sc;

    public Console() {
        menu = new Menu(this);
        this.sc = new Scanner(System.in);
    }
    @Override
    public int printMenu() {
        System.out.println(menu.printMenu());
        while (true) {
            System.out.print("Введите пункт меню: ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice >= 0 && choice <= menu.getMenuRowsValue()) {
                    return choice;
                } else {
                    System.out.printf("\nВведите число от 1 до %d!\n", menu.getMenuRowsValue());
                }
            } else {
                System.out.printf("\nВведите число от 1 до %d!\n", menu.getMenuRowsValue());
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