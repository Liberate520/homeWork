package com.homeWork.familytreeapp.repository;

import java.util.List;

public interface Repository<T> {
    void addParent(T parent, T child);
    void addSibling(T sibling1, T sibling2);
    List<T> getChildren(T parent);
}
