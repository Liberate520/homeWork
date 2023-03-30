package storage;
import java.util.ArrayList;

import data.Note;

public class ListStorage implements Storage {
    private ArrayList<String> notes;

    ListStorage() {
        notes = new ArrayList<>();
    }

    @Override
    public void save(String userString) {
        notes.add(userString);
    }

    @Override
    public String read() {
        String allNotes = "";
        for (String note : notes) {
            allNotes += note;
            allNotes += "\n";
        }
        return allNotes;
    }

    @Override
    public Note readNote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readNote'");
    }

}
