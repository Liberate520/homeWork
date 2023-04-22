package com.homeWork.familytreeapp.model;

import java.util.List;

public interface GenealogicalTree<T extends Person<T>> {
    void addParent(T parent, T child);
    void addSibling(T sibling1, T sibling2);
    List<T> getChildren(T parent);
}

