package fam_tree.family_tree;

import java.util.List;
import java.time.LocalDate;

public interface TreeItem<T> extends Comparable<T> {


    int getAge();
    String getName();
    T getSpouse();
    LocalDate getBirthDay();
    void setId(int id);
    int getId();
    List<T> getParents();
    List<T> getChildren();
    void addParents(T t);
    void addChildren(T t);
    void setSpouse(T t);

}
