package model.humans.comporator;

import model.humans.FamilyTreeItem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class HumanBirthdayComporator<E extends FamilyTreeItem> implements Comparator<E> {

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public int compare(E humah1, E human2) {
        try {
            Date date1 = format.parse(humah1.getDateOfBirth());
            Date date2 = format.parse(human2.getDateOfBirth());
            return date1.compareTo(date2);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
