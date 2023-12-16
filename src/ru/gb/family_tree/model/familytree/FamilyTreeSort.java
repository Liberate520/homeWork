package ru.gb.family_tree.model.familytree;

import ru.gb.family_tree.model.comparator.FamilyTreeComparatorByDate;
import ru.gb.family_tree.model.comparator.FamilyTreeComparatorByName;
import ru.gb.family_tree.model.comparator.TreeNode;

import java.util.List;

public class FamilyTreeSort<E extends TreeNode<E>> extends FamilyTree {

    public void sortByName(List<E> subList) {
        subList.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByDate(List<E> subList) {
        subList.sort(new FamilyTreeComparatorByDate<>());
    }
}
