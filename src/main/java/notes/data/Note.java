package notes.data;

import java.time.LocalDate;

public class Note {
    private String note;
    private String date;

    public Note(String note) {
        this.note = note;
        this.date = LocalDate.now().toString();
    }

    @Override
    public String toString() {
        return String.format("%10s | %s", date, note);
    }

    protected String getNote() {
        return note;
    }

    protected void setNote(String newNote) {
        note = newNote;
    }

    protected String getDate() {
        return date;
    }
}
