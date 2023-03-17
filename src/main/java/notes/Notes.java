package notes;

import java.util.ArrayList;
import java.util.Arrays;

public class Notes extends Note {
    ArrayList<Note> notes = new ArrayList<Note>();

    public Notes(){
        this.notes = new ArrayList<Note>();
    }

    public Notes(ArrayList<Note> notes) {

        this.notes.addAll(notes);
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Note note : notes) {
            sb.append(note.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
