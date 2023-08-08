package view.parse_data;

import java.time.LocalDate;

public interface IParseData {
    int tryParseInt(String text);
    LocalDate tryParseDate(String text);
}
