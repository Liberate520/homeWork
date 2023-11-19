package homeWork.src.model.member;

import homeWork.src.model.tree.TreeItem;

import java.util.Comparator;

public class FamilyMemberCompareByBirthDate<M extends TreeItem<M>> implements Comparator<M> {
    @Override
    public int compare(M o1, M o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
