package ui;


import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View{
    private final Scanner sc;

    public ConsoleUI() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("\n======= Главное меню =========");
        System.out.println("\t1. Показать все заметки");
        System.out.println("\t2. Добавить заметку");
        System.out.println("\t3. Удалить заметку");
        System.out.println("\t0. Выход");
        System.out.print("Введите пункт меню: ");

    }

    public int userChoice(){
        return sc.nextInt();
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

    public void addedNote(){
        System.out.println("\nЗаметка добавлена\n");
    }

    public void removeNote(){
        System.out.println("\nЗаметка удалена\n");
    }

    public void choiceRemove(){
        System.out.print("\nВведите номер заметки: ");
    }

    public int userChoiceRemove(){
        return sc.nextInt();
    }

    public void emptyNotebook(){
        System.out.println("\nВ записной книжке нет записей!\n");
    }

}
