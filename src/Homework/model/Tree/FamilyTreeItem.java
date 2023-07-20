package Homework.model.Tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    void setId(long id);
    long genId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();
    LocalDate getDeath();
    LocalDate getBirth();
    List<T> getParents();
    List<T> getChildren();

    int getAge();
}
