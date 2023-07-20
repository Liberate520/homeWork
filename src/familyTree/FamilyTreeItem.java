package familyTree;

import human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getSurname();
    String getName();
    String getPatronymic();
    String getFullName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<T> getParents();
    List<T> getChildren();
    int getAge();
}
