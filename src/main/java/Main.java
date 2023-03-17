import notes.*;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Note note = new Note("Какая то заметка 1");
//        Note note2 = new Note("Какая то заметка 2");
//        Note note3 = new Note("Какая то заметка 3");
//        ArrayList<Note> noteList = new ArrayList<>(Arrays.asList(note, note2, note3));
//        Notes notes = new Notes(noteList);
//        Formatter f = new Formatter();
//        String str = f.parseOut(notes);
//        Saver svr = new Saver();
//        svr.save(str);
//        Loader loader = new Loader();
//        String json = loader.getData();
//        Notes n = f.parseIn(json);
//        System.out.println(n);
//
//        System.out.println(str);
//        Notes n2 = f.parseIn(str);
//        System.out.println(n2);
        View view = new ConsoleUI();
        Notes notes = new Notes();
        Presenter presenter = new Presenter(view, notes);

        view.start();



    }
}
