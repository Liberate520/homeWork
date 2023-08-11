package view.parse_data;

import java.time.LocalDate;

public class ParseData implements IParseData{

    public int tryParseInt(String text) {
        try {
            return Integer.parseInt(text);
        }
        catch (Exception e) {
            return -1;
        }
    }

    public LocalDate tryParseDate(String text) {
        String[] date = text.split("-");
        try {
            int day = Integer.parseInt(date[0]);
            int mouth = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            return LocalDate.of(year, mouth, day);
        }
        catch (Exception e) {
            return null;
        }
    }
}
