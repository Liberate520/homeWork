package MyNote;

import java.util.ArrayList;


public class Model {
    private ArrayList<Record> records;
    private String note;
    private FileHandlers fileHandler;

    public Model(String note) {
        this.note = note;
        records = new ArrayList<Record>();
        load();
    }
    
    public void addRecord(String text) {
        records.add(new Record(text));
        save();
    }

    public void save() {
        fileHandler.save(records);
    }

    public void load() {
        records = fileHandler.load();
    }


    
    public Record removeRecord(int index) {
        
        return records.remove(index);
       
        
    }


    public String getNote() {
        return note;
    }
    public ArrayList<Record> getRecords() {
        return records;
    }
    public void setNote(String note) {
        this.note = note;
    }
    
}
