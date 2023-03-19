package notes;

import notes.data.Note;
import notes.data.Notes;

public interface Service {
    public Notes getNotes();


    public void save();

    public void delete(int index);
    public void addNote(Note note);
}
