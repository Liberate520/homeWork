package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Validation {

    public Validation() {
    }

    public boolean isValidGender(String gender) {
        return (Objects.equals(gender, "Female") || Objects.equals(gender, "Male") || Objects.equals(gender, "None"));
    }

    public boolean isDateValid(String date, boolean ifEmpty) {
        if (date == null) {
            date = "";
        }
        if (ifEmpty) {
            if (date.isEmpty()) {
                return true;
            }
        }
        boolean isTrueDate = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate.parse(date, formatter);
        } catch (DateTimeParseException ex) {
            isTrueDate = false;
        }
        return isTrueDate;
    }

    public boolean isNextInt(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }
}
