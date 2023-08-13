package Human;

import java.util.Comparator;

import Servis.HumanItem;

public class HumanConparatorByAge<T extends HumanItem <T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
