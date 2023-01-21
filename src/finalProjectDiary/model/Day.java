package homeWork.src.finalProjectDiary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Day implements Serializable {

    private List<Record> records;

    public Day() {
        this.records = new ArrayList<>();
    }

    public List<Record> getRecords() {
        return records;
    }


    public void addRecord(Record record) {
        records.add(record);
    }

    @Override
    public String toString() {
        StringBuilder dayRecords = new StringBuilder();
        dayRecords.append(" Найдено записей - ").append(records.size()).append(":\n");
        int count = 0;
        for (Record record : records) {
            dayRecords.append("\t\tЗапись ").append(++count).append(".").append(record);
        }
        return dayRecords.toString();
    }
}
