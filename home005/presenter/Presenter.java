package presenter;

import model.Note;
import model.Notes;
import view.View;

public class Presenter {
    private Notes notebook;

    public Presenter(View view, Notes notebook) {
        this.notebook = notebook;
        view.setPresenter(this);
    }

    public void addNote(String nn) {
        Note newNote = new Note();
        newNote.setNote(nn);
        notebook.addNote(newNote);
    }

    public String printAll() {
        return notebook.showNotes();
    }
}
