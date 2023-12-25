package ru.gb.family_tree.model.comparator;

import ru.gb.family_tree.model.human.Human;

import java.io.Serializable;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setId(long id);
    long getId();
    int getAge();
    String getName();
    void addToChild(T child);
    Object getGender();
    void setFather(T parent);
    void setMother(T parent);
    Object getSpouse();
    void setSpouse(Object o);
    void addParents(T parent);
    List<Human> getChildren();
    void addChild(T child);
    List<Human> getParents();
}




