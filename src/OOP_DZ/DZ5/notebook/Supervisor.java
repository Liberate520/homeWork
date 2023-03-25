package OOP_DZ.DZ5.notebook;

import OOP_DZ.DZ5.notebook.records.Record;
import OOP_DZ.DZ5.notebook.records.RecordsList;
import OOP_DZ.DZ5.notebook.storage.Storage;

import java.util.List;

public class Supervisor implements Service{
    private RecordsList recordsList;
    private Storage storage;

    public Supervisor(RecordsList recordsList, Storage storage) {
        this.recordsList = recordsList;
        this.storage = storage;
        setRecords(storage.read().getRecords());
    }

    @Override
    public int startFrom() {
        return recordsList.startFrom();
    }

    @Override
    public String getRecordFromList(int id) {
        return recordsList.getRecordFromList(id);
    }

    @Override
    public List<Record> getRecords() {
        return recordsList.getRecords();
    }

    @Override
    public void setRecords(List<Record> records) {
        recordsList.setRecords(records);
    }

    @Override
    public String getRecordInfo() {
        return recordsList.getRecordInfo();
    }

    @Override
    public void addRecord(Record record) {
        recordsList.addRecord(record);
    }

    @Override
    public boolean removeRecord(int id) {
        return recordsList.removeRecord(id);
    }

    @Override
    public boolean changeRecord(int id, String newRecord) {
        return recordsList.changeRecord(id,newRecord);
    }

    @Override
    public RecordsList readFromFile() {
        return storage.read();
    }

    @Override
    public void writeToFile() {
        storage.write();
    }
}
