package presenter;

import notes.ActionsFile;
import notes.Formatter;

import notes.Note;
import notes.Notes;
import ui.View;

public class Presenter {
    private View view;
    private Notes notes;
    private Note note;

    public Presenter(View view, Notes notes) {
        this.view = view;
        this.notes = notes;
        view.setPresenter(this);
    }

    public void getChois(int choice) {
        ActionsFile actionsFile = new ActionsFile();
        Formatter formatter = new Formatter();
        String data = actionsFile.getData();
        Notes notes = formatter.parseIn(data);
        switch (choice) {
            case 1:
                System.out.println(notes.toString());
                view.start();
                break;
            case 2:
                note = new Note(view.scan("Введите текст заметки: "));
                notes.addNote(note);
                actionsFile.save(formatter.parseOut(notes));
                view.start();
                break;
            case 3:
                break;
        }
    }
}
