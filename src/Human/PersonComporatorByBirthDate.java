package Human;

import java.util.Comparator;

public class PersonComporatorByBirthDate<T extends GroupItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirth().compareTo(o2.getBirth());
    }
}
