package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar implements Serializable {

    private List<CalendarEntry> baseCalendar;

    public Calendar() {
        this.baseCalendar = new ArrayList<>();
    }

    public List<CalendarEntry> getBaseCalendar() {
        return this.baseCalendar;
    }

    public void addRecord(CalendarEntry record) {
        baseCalendar.add(record);

    }

    @Override
    public String toString() {
        StringBuilder records = new StringBuilder();
        records.append("Найдено записей - ").append(baseCalendar.size()).append(":\n");
        int count = 0;
        for (CalendarEntry record : baseCalendar) {
            records.append("Запись").append(++count).append(".").append(record).append("\n");
        }
        return records.toString();
    }

    public CalendarEntry getDayRecords(LocalDate dataDay) {
        for (int i = 0; i < baseCalendar.size(); i++) {
            if (baseCalendar.get(i).equals(dataDay)) {
                return baseCalendar.get(i);
            }
        }
        return null;
    }



}
