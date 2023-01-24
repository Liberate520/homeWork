package model;

import java.io.Serializable;
import java.time.LocalDate;

public class CalendarEntry implements Serializable {

    private LocalDate data;

    private String text;

    public CalendarEntry(LocalDate data, String text) {
        this.data = data;
        this.text = text;
    }

    public LocalDate getData() {
        return data;
    }

    public String getText() {
        return text;
    }

    public CalendarEntry newElement(LocalDate data, String text) {
        return newElement(data, text);
    }

    @Override
    public String toString() {
        return " " + text + " Дата  " + data;
    }

}
