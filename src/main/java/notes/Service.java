package notes;

import notes.data.Note;
import notes.data.Notes;

public interface Service {
    Notes getNotes();


    void save();

    void delete(int index);
    void addNote(Note note);
    String getNote(int index);
    void setNote(String newNote, int index);
    String[][] toArray();
}
