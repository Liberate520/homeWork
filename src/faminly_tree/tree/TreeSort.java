package faminly_tree.tree;

import faminly_tree.human.comparators.HumanComparatorByAge;
import faminly_tree.human.comparators.HumanComparatorByBirth;
import faminly_tree.human.comparators.HumanComparatorByName;

import java.util.Collections;
import java.util.List;

public class TreeSort<E extends FamiliItem> {
    private List<E> tree;

    public TreeSort(List<E> tree) {
        this.tree = tree;
    }

    public void sortByName(){
        Collections.sort(tree, new HumanComparatorByName<>());
    }
    public void sortByAge(){
        Collections.sort(tree, new HumanComparatorByAge<>());
    }
    public void sortByBirth(){
        Collections.sort(tree, new HumanComparatorByBirth<>());
    }
}
