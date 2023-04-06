package model;

import java.util.ArrayList;

public class Notes {
    // ArrayList<Note> notes;
    ArrayList<String> notes;

    public Notes() {
        this.notes = new ArrayList<>();
    }

    // public void addNote(Note note) {
    //     notes.add(note);
    // }
    public void addNote(String note) {
        notes.add(note);
    }

    // public void showNotes() {
    //     for (Note note : notes) {
    //         System.out.println(note);
    //     }
    // }
    public void showNotes() {
        for (String note : notes) {
            System.out.println(note);
        }
    }
}
