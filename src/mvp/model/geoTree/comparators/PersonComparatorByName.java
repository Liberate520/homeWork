package mvp.model.geoTree.comparators;
import java.util.Comparator;

import mvp.model.geoTree.GeoTreeItem;

public class PersonComparatorByName<T extends GeoTreeItem<T>> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
