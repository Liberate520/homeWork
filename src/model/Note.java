package model;

import java.time.LocalDate;

public class Note {
    private LocalDate date;
    private String text;

    public Note(String text){
        this.text = text;
        date = LocalDate.now();

    }

    @Override
    public String toString() {
        return "Note{" +
                "date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
