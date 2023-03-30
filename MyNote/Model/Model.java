package MyNote.Model;

import MyNote.Notebook;
import MyNote.Record;

public class Model {
    private Notebook records;
    private String note;
    private FileHandlerClass fileHandler;

    public Model(String note) {
        this.note = note;
        records = new Notebook();
        this.fileHandler = new FileHandlerClass(note);
        load();
    }

    public void addRecord(String text) {
        records.addRecord(new Record(text));
        save();
    }

    public void save() {
        fileHandler.save(records);
    }

    public void load() {
        records = fileHandler.load();
    }

    public boolean removeRecord(int index) {

        return records.removeRecord(index);

    }

    public String getNote() {
        return note;
    }

    public Notebook getRecords() {
        return records;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
