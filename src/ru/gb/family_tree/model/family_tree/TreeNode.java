package ru.gb.family_tree.model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setId(int id);
    int getId();
    T getFather();
    T getMother();
    void addChild(T human);
    void addParent(T human);
    String getName();
    int getAge();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();

}
