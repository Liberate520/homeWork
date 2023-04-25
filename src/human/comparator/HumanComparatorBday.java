package human.comparator;

import human.Human;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class HumanComparatorBday implements Comparator<Human> {

    SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
    @Override
    public int compare(Human o1,Human  o2) {
        Date o1_bDay = null;
        Date o2_bDay = null;
        try {
             o1_bDay = formatDate.parse(o1.getbDay());
             o2_bDay = formatDate.parse(o2.getbDay());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return o1_bDay.compareTo(o2_bDay);
    }

}
