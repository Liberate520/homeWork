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

    public void editNote(int index, String nn){
        Note newNote = new Note();
        newNote.setNote(nn);
        notebook.edit(index, newNote);
    }


    public void deleteNote(int index) {
        notebook.delete(index - 1);
    }
}
