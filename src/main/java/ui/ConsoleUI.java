package ui;

import notes.data.Notes;
import presenter.Presenter;
import ui.menuitems.viewNotes;

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
        mineMenu.addItem(new viewNotes(this));
        System.out.println(mineMenu.printMenu());
        int choice = Integer.parseInt(scan("Выберите пункт меню: "));
        mineMenu.run(choice);


    }

    @Override
    public String scan(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public void viewNotes() {
        Notes notes = presenter.getNotes();
        System.out.println(notes);
    }
}
