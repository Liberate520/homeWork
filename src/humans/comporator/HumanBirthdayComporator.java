package humans.comporator;

import humans.Human;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class HumanBirthdayComporator implements Comparator<Human> {

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public int compare(Human humah1, Human human2) {
        try {
            Date date1 = format.parse(humah1.getDateOfBirth());
            Date date2 = format.parse(human2.getDateOfBirth());
            return date1.compareTo(date2);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
