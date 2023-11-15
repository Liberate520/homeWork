package my_family_tree.model.tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeItem<E> extends Comparable<E> {

    int getAge();
    String getName();
    E getSpouse();
    LocalDate getBirthDay();
    void setId(int id);
    int getId();
    List<E> getParents();
    List<E> getChildren();
    void addParents(E e);
    void addChildren(E e);
    void setSpouse(E e);
}
