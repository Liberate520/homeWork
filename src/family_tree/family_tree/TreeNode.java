package family_tree.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParents(T human);
    String getName();
    LocalDate getDeadDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
}
