package src.comparator;

import src.Human;
import src.It;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class HumanComparator<T extends It> implements Comparator<T> {
    private final SortBy sortBy;
    public HumanComparator(SortBy sortBy) {
    this.sortBy = sortBy;
    }

    @Override
    public int compare(T o1, T o2) {
        switch (sortBy) {
            case AGE -> {return Integer.compare(o1.getAge(), o2.getAge());}
            case LAST_NAME -> {return o1.getLastName().compareTo(o2.getLastName());}
            case FIRST_NAME -> {return o1.getFirstName().compareTo(o2.getFirstName());}
            case PATRONYMIC -> {return o1.getPatronymic().compareTo(o2.getPatronymic());}
            case DATE_OF_BIRTH -> {
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    Date o1Date = format.parse(o1.getDateOfBorn());
                    Date o2Date = format.parse(o2.getDateOfBorn());
                    return o1Date.compareTo(o2Date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return 0;
    }
}
