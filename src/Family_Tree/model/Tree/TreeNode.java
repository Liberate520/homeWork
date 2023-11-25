package Family_Tree.model.Tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeNode<E> extends Comparable<E> {

    int getAge();

    String getName();

    E getSpouse();

    LocalDate getBirthday();

    void setId(int id);

    int getId();

    List<E> getParents();

    List<E> getChildren();

    void addParent(E e);

    void addChildren(E e);

    void setSpouse(E e);
}