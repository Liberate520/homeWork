package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Human;

import java.io.Serializable;
import java.util.List;

public interface TreeItem<T> extends Serializable {
    String getName();
    int getAge();
    Human getFather();
    Human getMother();
    List<T> getChildren();
    List<T> getParents();
    long getId();
    void setId(long id);
}
