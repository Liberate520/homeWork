package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.comparators.EntityComparatorByAge;
import model.comparators.EntityComparatorByName;

public class FamilyTree<T extends BasicEntity> implements Serializable, Iterable<T> {
    private ArrayList<T> tree;

    // ==================================================================================
    // Constructors

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(ArrayList<T> tree) {
        this.tree = tree;
    }

    // ==================================================================================

    public void printTree() {
        for (T entity : tree) {
            System.out.println(entity);
        }
    }

    public T getEntityByID(int id) {
        for (T entity : tree) {
            if (id == entity.getId())
                return entity;
        }
        return null;
    }

    public void addEntity(T entity) {
        if (entity != null) {
            tree.add(entity);
        }
    }

    public void sortByName() {
        Collections.sort(tree, new EntityComparatorByName<>());
    }

    public void sortByAge() {
        Collections.sort(tree, new EntityComparatorByAge<>());
    }

    @Override
    public Iterator<T> iterator() {
        return tree.iterator();
    }
}
