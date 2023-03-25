package OOP_DZ.DZ5.notebook.records;

import java.util.*;

public class SimpleRecordsList implements RecordsList {

    private List<Record> records;

    public SimpleRecordsList() {
        this.records = new ArrayList<>();
    }


    public List<Record> getRecords() {
        return records;
    }

    @Override
    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public void addRecord(Record record) {
        records.add(record);
    }

    @Override
    public boolean removeRecord(int id) {
        for (Record item : records) {
            if (item.getId() == id) {
                records.remove(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeRecord(int id, String newRecord) {
        for (Record item : records) {
            if (item.getId() == id) {
                item.setRecord(newRecord);
                return true;
            }
        }
        return false;
    }

    @Override
    public int startFrom() {
        int max = 0;
        if (records.size() != 0) {
            for (Record item : records) {
                if (item.getId() > max) {
                    max = item.getId();
                }
            }
        }
        return max;
    }

    @Override
    public String getRecordFromList(int id) {
        for (Record item : records) {
            if (item.getId() == id) {
                return item.getRecord();
            }
        }
        return "No records found with your ID.";
    }

    @Override
    public String getRecordInfo() {
        StringBuilder sb = new StringBuilder();
        if (records.size() != 0) {
            sb.append("\n");
            for (int i = 0; i < records.size(); i++) {
                sb.append(records.get(i));
                if (i != records.size() - 1) {
                    sb.append("\n");
                }
            }
        } else sb.append("\nFile is Empty");
        return sb.toString();
    }
}
