package family_tree.model.family;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable, Comparable<T> {

    void setId(long id);

    long getId();

    T getFather();

    T getMother();

    boolean addChild(T human);

    boolean addParent(T human);

    String getName();

    LocalDate getDeathDate();

    LocalDate getBirthDate();

    List<T> getParentsList();

    List<T> getChildrenList();

    T getSpouse();

    void setSpouse(T human);

    Object getFamilyName();

    int getAge();

    void setFather(T human);

    void setMother(T human);
}
