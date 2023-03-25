package OOP_DZ.DZ5.notebook.records;

import java.util.*;

public interface RecordsList {

    String getRecordInfo();

    String getRecordFromList(int id);

    List<Record> getRecords();

    void setRecords(List<Record> records);

    int startFrom();

    void addRecord(Record record);

    boolean removeRecord(int id);

    boolean changeRecord(int id, String newRecord);
}
