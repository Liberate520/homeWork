package notes;

import notes.data.Note;

import java.util.ArrayList;

public class Notes {
    private ArrayList<Note> notes;
    public Notes() {
        this.notes = new ArrayList<Note>();
    }

//    @Override
    public void addNote(Note note) {
        notes.add(note);
    }

    public String getNote(int index) {
        return notes.get(index).getNote();
    }

//    @Override
    public void setNote(String newNote, int index) {
        Note note = notes.get(index - 1);
        note.setNote(newNote);
    }

//    @Override
    public String[][] toArray() {
        return new String[0][];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            sb.append(String.format("%s,\n", notes.get(i)));
        }
        return sb.toString();
    }

//    @Override
    public Notes loadNotes() {
        ActionsFile actionsFile = new ActionsFile();
        String data = actionsFile.getData();
        Formatter formatter = new Formatter();
        return formatter.parseIn(data);
    }

//    @Override
    public Notes getNotes() {
        return this;
    }

//    @Override
    public String getDate(int index) {
        return notes.get(index).getDate();
    }

//    @Override
    public void save() {
        ActionsFile actionsFile = new ActionsFile();
        Formatter formatter = new Formatter();
        actionsFile.save(formatter.parseOut(this));
    }

//    @Override
    public void delete(int index) {
        notes.remove(index - 1);

    }

    public int size() {
        return notes.size();
    }
}
