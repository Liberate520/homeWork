package presenter;

import notes.data.Note;
import notes.Notes;
import ui.View;

public class Presenter {
    private View view;
    private Notes notes;



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
        //Не уверен что такая реализация правильная. Скорее всего исключения надо выбрасывать отдельно...
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
