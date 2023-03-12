package sorted;

import java.util.Calendar;
import java.util.Comparator;
import genealogicalTree.*;

public class ComparatorByYear implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o2.getBirthDate(), o1.getBirthDate());
    }
}
