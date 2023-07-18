package familyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    void setId(int id);
    long getId();
    int getAge();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getSurname();
    String getName();
    LocalDate dateOfDeath();
    LocalDate dateOfBirthday();
    List<T> getParents();
    List<T> getChildren();
}
