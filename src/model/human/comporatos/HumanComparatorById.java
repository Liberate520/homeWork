package model.human.comporatos;
import java.util.Comparator;

import model.tree.HumanGroupItem;

public class HumanComparatorById<T extends HumanGroupItem> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
