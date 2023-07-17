package mvp.model.geoTree.comparators;
import java.util.Comparator;

import mvp.model.geoTree.GeoTreeItem;

public class PersonComparatorByDateOfBirth<T extends GeoTreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getDateOfBirth().getYear(), o2.getDateOfBirth().getYear());
    }
}
