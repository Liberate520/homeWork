package ru.gb.family_tree;

import ru.gb.data.Gender;
import ru.gb.human.Human;

public interface FamilyTreeItem<T> {
    void setId(long humanId);
    void addChild(T human);
    void addParent(T human);
    public String getName();
    public long getAge();
}
