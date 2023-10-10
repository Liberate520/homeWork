package View.Checks;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CheckDate {

    public static LocalDate checkDate(String data){
        if(data.isEmpty()){
            return null;
        }
        try {
            String[] dateParts = data.split("\\.");
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);
            return LocalDate.of(year, month, day);
        } catch (DateTimeParseException e) {
            System.out.println("Некорректный формат даты: " + data);
        }
        return null;
    }

}
