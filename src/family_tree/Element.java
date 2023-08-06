package family_tree;

import java.util.List;

public interface Element<E> {
    void setId(long l);
    long getId();
    String getName();
    int getAge();
    E getFather();
    E getMother();
    List<E> getParents();
    List<E> getChildren();
    boolean addChild(E human);
    boolean addParent(E human);
    E getSpouse();
    void setSpouse(E human);
}
