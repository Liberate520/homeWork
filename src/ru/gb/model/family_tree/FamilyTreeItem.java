package ru.gb.model.family_tree;

public interface FamilyTreeItem<T> {
    void setId(long humanId);
    void addChild(T human);
    void addParent(T human);
    public String getName();
    public long getAge();
}
