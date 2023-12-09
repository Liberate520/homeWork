package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    Integer getId();
    String getName();
    Integer getAge();
    T getFather();
    T getMother();
    LocalDate getDateBirthday();
    LocalDate getDateDeath();
    void setChildren(T human);
    List<T> getChildren();
    List<T> getParents();
}
