package notebook;

import java.util.List;

public interface Service {
    int startFrom();

    String getRecordFromList(int id);
    List<Record> getRecords();

    String getRecordInfo();

    void addRecord(Record record);

    boolean removeRecord(int id);

    boolean changeRecord(int id, String newRecord);

}
