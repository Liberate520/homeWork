package ru.gb.model.family_tree;

import java.util.List;

public interface FamilyTreeItem<T> {
    void setId(long humanId);
    public long getId();
    void addChild(T human);
    void addParent(T human);
    public String getName();
    public long getAge();
    public List<T> getParents();
}
