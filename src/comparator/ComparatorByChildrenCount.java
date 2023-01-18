package comparator;

import entity.*;

import java.util.Comparator;

public class ComparatorByChildrenCount<T extends Mammal> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getChildren().size(), o1.getChildren().size());
    }
}