package presenter;

import notes.ActionsFile;
import notes.Formatter;
import notes.data.Note;
import notes.data.Notes;
import notes.Service;
import ui.View;

import java.util.ArrayList;

public class Presenter {
    private View view;
    private Service service;

    public Service getService() {
        return service;
    }

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service.loadNotes();
        view.setPresenter(this);
    }

    public Notes getNotes() {
        return service.getNotes();
    }

    public void addNote(Note note) {
        service.addNote(note);
    }

    public void removeNote(int index) {
        service.delete(index);
    }

    public void replaceNote(int index, String newNote) {
        try {
            service.setNote(newNote, index);
        } catch (IndexOutOfBoundsException ex){
            view.print("Указан неверный номер заметки");
            view.print(ex.getMessage());
        }
    }

    public void saveNotes() {
        service.save();
    }
}
