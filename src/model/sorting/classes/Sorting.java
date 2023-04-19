package model.sorting.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.tree.interfaces.iTree;

public class Sorting<E> {
    private List<E> persons = new ArrayList<>();
    private iTree<E> tree;

    public Sorting(iTree<E> tree) {
        this.tree = tree;
    }

    public void sortByName() {
        persons = tree.getTree();
        Collections.sort(persons, new HumanComparatorByName());
    }

    public void sortByBirthDate() {
        persons = tree.getTree();
        Collections.sort(persons, new HumanComparatorByBirth());
    }

}
