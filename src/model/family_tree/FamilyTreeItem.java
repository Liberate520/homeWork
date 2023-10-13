package model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> {
    void setId(int i);
    int getId();
    String getName();
    LocalDate getBirthDate();
    void setHusband(List<T> husbands);
    List<T> getHusbands();
    void setFather(T father);
    void setMother(T mother);
    List<T> getChildren();
    void setChildren(List<T> children);
    T getMother();
    T getFather();
}
