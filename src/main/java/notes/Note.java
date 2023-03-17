package notes;

import java.time.LocalDate;

public class Note {
    private String note;
    private String date;

    public Note() {
        this.date = "";
        this.note = "";
        }

    public Note(String note) {
        this.note = note;
        this.date = LocalDate.now().toString();
    }

    public String getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = LocalDate.now().toString();
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }



    @Override
    public String toString() {
        return String.format("Note: %s, Date: %s", note, date);
    }
}
