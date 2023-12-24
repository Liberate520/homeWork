package FamilyTree.model.FT;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface commonParam <T> extends Serializable, Comparable<T> {
    void setId(long id);
    long getId();
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    int getAge();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    List<T> getParents();
    List<T> getChildren();
    void setSpouse(T human);
    T getSpouse();
}
