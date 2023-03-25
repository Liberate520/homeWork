package OOP_DZ.DZ5.notebook;

import OOP_DZ.DZ5.notebook.records.Record;
import OOP_DZ.DZ5.notebook.records.RecordsList;

import java.util.List;

public interface Service {
    int startFrom();

    String getRecordFromList(int id);

    List<Record> getRecords();

    void setRecords(List<Record> records);

    String getRecordInfo();

    void addRecord(Record record);

    boolean removeRecord(int id);

    boolean changeRecord(int id, String newRecord);

    RecordsList readFromFile();  //задел на возможное будущее этого проекта

    void writeToFile();

}
