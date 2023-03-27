package model.commands;

import java.util.Date;

public class Note {
    private String text;
    private Date date;

    public Note(String text) {
        this.text = text;
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
