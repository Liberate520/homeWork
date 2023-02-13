package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class Dates {
    String date;



    public Dates() {
        this("");
    }

    public Dates(String dates) {
        this.date = dates;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTodayDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    public HashMap<String, Integer> parseDate(String parseDate) {
        HashMap<String, Integer> result = new HashMap<>();
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        if (parseDate.isEmpty()) {
            return result;
        }
        try {
            Date parDate = sd.parse(parseDate);
            calendar.setTime(parDate);
            int day = calendar.get(Calendar.DATE);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            result.put("year", year);
            result.put("month", month);
            result.put("day", day);
            return result;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return result;
        }
    }


    public boolean datesCompare(String date1, String date2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        if (Objects.equals(date1, "")){
            date1 = "01.01.0001";
        }
        if (Objects.equals(date2, "")){
            date2 = getTodayDate();
        }
        try {
            Date dayOne = dateFormat.parse(date1);
            Date dayTwo = dateFormat.parse(date2);
            return dayOne.compareTo(dayTwo) <= 0;

        } catch (ParseException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
