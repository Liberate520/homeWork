package ui;

import notes.data.Note;
import notes.data.Notes;
import presenter.Presenter;
import ui.menuitems.*;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void selection() {
        Menu mineMenu = new Menu(this);
        mineMenu.addItem(new ViewNotes(this));
        mineMenu.addItem(new AddNote(this));
        mineMenu.addItem(new RemoveNote(this));
        mineMenu.addItem(new EditNote(this));
        mineMenu.addItem(new Exit(this));
        flag = true;
        while (flag) {
            System.out.println(mineMenu.printMenu());
            int choice = Integer.parseInt(scan("Выберите пункт меню: "));
            mineMenu.run(choice);
        }
    }

    @Override
    public String scan(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void showNotes() {
        Notes notes = presenter.getNotes();
//        System.out.println(notes);
        print("Заметки");
        print(String.format("%4s | %10s | %s", "№", "Дата", "Заметка"));
        print("-".repeat(5)+"+"+"-".repeat(12)+"+"+"-".repeat(60));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            sb.append(String.format("%4d | %10s | %s\n", i+1, notes.getDate(i), notes.getNote(i)));
        }
        print(sb.toString());

    }

    @Override
    public void addNote() {
        Note note = new Note(scan("Введите текст заметки: "));
        presenter.addNote(note);
    }
    @Override
    public void removeNote() {
        int index = Integer.parseInt(scan("Введите номер заметки для удаления"));

        presenter.removeNote(index);
    }

    @Override
    public void editNote() {
        int index = Integer.parseInt(scan("Введите номер заметки для редактирования"));
        String newNote = scan("Введите текст заметки: ");
        presenter.replaceNote(index, newNote);
    }

    @Override
    public void exit() {
        presenter.saveNotes();
        flag = false;
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
