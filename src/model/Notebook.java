package model;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Note> notes;
    public Notebook () {
        notes = new ArrayList<>();
    }
    public void addNote (Note note){
        notes.add(note);
    }

    public List<Note> getNotes(){
        return notes;
    }
}
