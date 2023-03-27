package presenter;

import notes.DataIO;
import notes.data.Note;
import notes.Notes;
import ui.View;

public class Presenter {
    private View view;
    private Notes notes;

    private DataIO dataIO;



    public Presenter(View view, Notes notes, DataIO dataIO) {
        this.view = view;
        this.dataIO = dataIO;
        this.notes = notes.loadNotes(dataIO);
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
        if (index<0 || index > notes.size()-1) {
            view.print("Указан неверный номер заметки");
        }
        else
            notes.setNote(newNote, index);
    }

    public void saveNotes() {
        notes.save(dataIO);
    }
}
