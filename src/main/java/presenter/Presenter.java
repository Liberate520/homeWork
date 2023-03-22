package presenter;

import notes.data.Note;
import notes.Notes;
import ui.View;

public class Presenter {
    private View view;
    private Notes notes;

//    public Service getService() {
//        return service;
//    }

    public Presenter(View view, Notes notes) {
        this.view = view;
        this.notes = notes.loadNotes();
        view.setPresenter(this);
    }

    public Notes getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.addNote(note);
    }

    public void removeNote(int index) {
        notes.delete(index);
    }

    public void replaceNote(int index, String newNote) {
        try {
            notes.setNote(newNote, index);
        } catch (IndexOutOfBoundsException ex){
            view.print("Указан неверный номер заметки");
            view.print(ex.getMessage());
        }
    }

    public void saveNotes() {
        notes.save();
    }
}
