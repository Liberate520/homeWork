package MyNote;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List <Record> notes;
    public Notebook(){
        notes=new ArrayList<Record>();
    }
          
    public List<Record> getNotes() {
        return notes;
    }
    public void setNotes(List<Record> notes) {
        this.notes = notes;
    }
    public void addRecord(Record record) {
        notes.add(record);
    }
    public boolean removeRecord(int index) {
        if (index < 0 || index >= notes.size()) {
            return false;
        }
        notes.remove(index);
        return true;
    }
    public List<Record> getAllRecords() {
        return notes;
    }

    public boolean isEmpty() {
        return notes.isEmpty();
    }

}

