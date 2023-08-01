package Human;

import java.util.Comparator;

import Servis.HumanItem;

public class HumanComparatorByBirthDate<T extends HumanItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getDataOfBirth().compareTo(o2.getDataOfBirth());
    }

}
