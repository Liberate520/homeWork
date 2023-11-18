package homeWork.src.member;

import homeWork.src.tree.TreeItem;

import java.util.Comparator;

public class FamilyMemberComparatorByAge<M extends TreeItem<M>> implements Comparator<M> {
    @Override
    public int compare(M o1, M o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
