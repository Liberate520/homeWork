package family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    void addChild(T human);
    void addParent(T human);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();

    String getInfo();
}
