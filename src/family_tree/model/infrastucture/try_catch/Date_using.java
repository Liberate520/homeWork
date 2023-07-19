package family_tree.model.infrastucture.try_catch;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date_using {
    public LocalDate tryLocalDate(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = "01.01.9999";
        LocalDate localDate = LocalDate.parse(date, formatter);
        try {
            localDate = LocalDate.parse(string, formatter);
        } catch (Exception ignored) {
        }
        return localDate;
    }
}
