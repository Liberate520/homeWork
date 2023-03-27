package notes;

import notes.data.Note;

import java.util.ArrayList;

public class Notes {
    private ArrayList<Note> notes;

    public Notes() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public String getNote(int index) {
        return notes.get(index).getNote();
    }

    public void setNote(String newNote, int index) {
        Note note = notes.get(index - 1);
        note.setNote(newNote);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Note note : notes) {
            sb.append(String.format("%s,\n", note));
        }
        return sb.toString();
    }


    public Notes loadNotes(DataIO dataIO) {
        String data = dataIO.getData();
        Formatter formatter = new Formatter();
        return formatter.parseIn(data);
    }


    public String getDate(int index) {
        return notes.get(index).getDate();
    }


    public void save(DataIO dataIO) {

        Formatter formatter = new Formatter();
        dataIO.save(formatter.parseOut(this));
    }


    public void delete(int index) {
        notes.remove(index - 1);

    }

    public int size() {
        return notes.size();
    }
}
