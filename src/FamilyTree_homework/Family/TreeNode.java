package FamilyTree_homework.Family;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public interface TreeNode<T> extends Serializable, Comparator<T> {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
}
