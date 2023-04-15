package tree;

import treeUnits.Human;
import svc.Writable;
import treeUnits.TreeUnit;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс дерева
 */
public class FamilyTree<E extends TreeUnit> implements Serializable, Iterable<E> {
    private final List<E> listUnits;

    public FamilyTree(List<E> listUnits) {
        this.listUnits = listUnits;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<E> getUnits() {
        return listUnits;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorUnits(this.listUnits);
    }
}