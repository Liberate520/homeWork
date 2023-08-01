package family_tree.model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeInterface<E> {
    List<E> getParents();
    boolean addChild(E child);
    void setId(long l);
    List<E> getChildren();
    boolean addParent(E parent);
    String getName();
    E getSpouse();
    void setSpouse(E spouse);
    long getId();
    E getFather();
    E getMather();
    LocalDate getDeathData();
    LocalDate getBirthData();

    int getAge();
}
