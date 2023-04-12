package model;

import java.util.ArrayList;

public class Notes {
    private ArrayList<Note> notes;

    public Notes() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public String showNotes() {
        StringBuilder allNotes = new StringBuilder();
        for (Note note : notes) {
            allNotes.append(note.toString());
            allNotes.append("\n");
        }
        return allNotes.toString();
    }

    public void delete(int index){
        notes.remove(index);
    }

   public void edit(int index, Note note){
        notes.set(index, note);
    }
}
