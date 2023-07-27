package human;

import genealogicalTree.GTgeneric;

import java.util.Comparator;

public class ComparatorByAge<T extends Human> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2 ) {
        return Integer.compare(o1.showAge(), o2.showAge());
    }


}
