package ui;

import notes.data.Note;
import notes.data.Notes;
import presenter.Presenter;
import ui.menuitems.AddNote;
import ui.menuitems.RemoveNote;
import ui.menuitems.ViewNotes;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void selection() {
//        int choice = 1;
//        int choice = Integer.parseInt(scan("Выберите: 1 - просмотр, 2 - добавить новую запись," +
//                " 3 - удалить заметку, 4 - редактировать запись, 5 - выход"));
        Menu mineMenu = new Menu(this);
        mineMenu.addItem(new ViewNotes(this));
        mineMenu.addItem(new AddNote(this));
        mineMenu.addItem(new RemoveNote(this));
        System.out.println(mineMenu.printMenu());
        int choice = Integer.parseInt(scan("Выберите пункт меню: "));
        mineMenu.run(choice);


    }

    @Override
    public String scan(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void showNotes() {
        Notes notes = presenter.getNotes();
        System.out.println(notes);
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

}
