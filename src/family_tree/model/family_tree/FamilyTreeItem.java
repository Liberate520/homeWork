package family_tree.model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    void addChild(T item);
    void addParent(T item);
    String getName();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();

    String getInfo();
}
