package notebook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Note {

    private final LocalDate date;
    private final String note;
    private final String description;

    public Note(LocalDate date, String note, String description) {
        this.date = date;
        this.note = note;
        this.description = description;
    }



    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = this.date.format(formatter);
        return String.format("%s %s; %s", formattedDate, note, description);
    }
}
