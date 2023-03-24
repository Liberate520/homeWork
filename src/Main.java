package Homework25_2;


import java.time.LocalDate;

import Homework25_2.Model.Note;
import Homework25_2.Model.Notebook;
import Homework25_2.Presenter.Presenter;
import Homework25_2.UI.Console;
import Homework25_2.UI.View;

public class Main {
    public static void main(String[] args) {


        Note note1 = new Note(LocalDate.now(),"доделать отдельное меню", "важно");
        Note note2 = new Note(LocalDate.now(),"доделать дз по Эксель", "срочно");
        Notebook notebook = new Notebook();
        notebook.add(note1);
        notebook.add(note2);

        View view = new Console();
        Presenter presenter = new Presenter(notebook, view);

        presenter.onClick();


    }
}