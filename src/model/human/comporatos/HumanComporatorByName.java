package model.human.comporatos;
import java.util.Comparator;

import model.tree.HumanGroupItem;

public class HumanComporatorByName<T extends HumanGroupItem> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
