package model.group.comparators;

import java.util.Comparator;
import model.human.NodeTree;

public class HumanComparatorByChildren<T extends NodeTree<T>> implements Comparator<T> {

    @Override
    public int compare(T p1, T p2) {
        if (p1.getChildrens() == null || p2.getChildrens() == null)
            return -1;
        else {
            for (int i = 0; i < Math.max(p1.getChildrens().size(), p2.getChildrens().size());) {
                return Integer.compare(p1.getChildrens().get(i).getId(), p2.getChildrens().get(i).getId());
            }
        }
        return 0;
    }
}
