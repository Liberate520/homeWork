package FamilyTree.model.FT;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface commonParam <T> extends Serializable, Comparable<T> {
    void setId(int id);
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
    T getSpouse();
    void setSpouse(T human);

    int getAge();

}
