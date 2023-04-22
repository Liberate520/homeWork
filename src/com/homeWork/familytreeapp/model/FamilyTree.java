package com.homeWork.familytreeapp.model;

import com.homeWork.familytreeapp.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree<T> implements Repository<T> {
    private Map<T, List<T>> familyTree;

    public FamilyTree() {
        this.familyTree = new HashMap<>();
    }

    @Override
    public void addParent(T parent, T child) {
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
        List<T> parentChildren = getChildren(sibling1);
        if (parentChildren == null || !parentChildren.contains(sibling1)) {
            throw new IllegalArgumentException("Не найден общий родитель для братьев и сестер.");
        }
        addParent(parentChildren.get(0), sibling2);
    }

    @Override
    public List<T> getChildren(T parent) {
        return familyTree.get(parent);
    }
}
