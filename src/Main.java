package Seminar6.src;

import Seminar5.Task.notebooks.Notes;
import Seminar5.Task.notebooks.RandomNotes;
import Seminar5.Task.presenter.Presenter;
import Seminar5.Task.ui.ConsoleUi;
import Seminar5.Task.ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUi();
        Notes notes = new RandomNotes();
        Presenter presenter = new Presenter(view,notes);
        while (true)view.launch();

    }


}
