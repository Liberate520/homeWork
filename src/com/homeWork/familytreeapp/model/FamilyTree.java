package com.homeWork.familytreeapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree<T extends Person<T>> implements GenealogicalTree<T> {
    private Map<T, List<T>> familyTree;

    public FamilyTree() {
        this.familyTree = new HashMap<>();
    }

    @Override
    public void addParent(T parent, T child) {
        child.setParent(parent);
        if (familyTree.containsKey(parent)) {
            familyTree.get(parent).add(child);
        } else {
            List<T> children = new ArrayList<>();
            children.add(child);
            familyTree.put(parent, children);
        }
    }

    @Override
    public void addSibling(T sibling1, T sibling2) {
        T parent = sibling1.getParent();
        if (parent == null || !parent.equals(sibling2.getParent())) {
            throw new IllegalArgumentException("У обоих братьев и сестер должен быть один и тот же родитель в семейном дереве.");
        }
        addParent(parent, sibling2);
    }

    @Override
    public List<T> getChildren(T parent) {
        if (familyTree.containsKey(parent)) {
            return familyTree.get(parent);
        } else {
            return null;
        }
    }
    
}




