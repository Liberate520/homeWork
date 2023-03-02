package model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.entity.BasicEntity;
import model.entity.comparators.EntityComparatorByAge;
import model.entity.comparators.EntityComparatorByName;

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

    public String printTree() {
        StringBuilder sb = new StringBuilder();
        for (T entity : tree) {
            sb.append(entity.toString());
            sb.append("\n");
        }

        return sb.toString();
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
