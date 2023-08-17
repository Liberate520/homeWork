package ru.gb.fam_tree.model.family_tree.all_tree_items;

import java.util.List;

public interface FamilyTreeItem<T> {
    void setId(long l);
    List<T> getParents();
    List<T> getChildrens();
    String getName();
    T getSpouse();
    long getId();
    void addParent(T t);
    int getDaysOfLife();
    void setSpouse(T t2);
    void addChild(T t);
}
