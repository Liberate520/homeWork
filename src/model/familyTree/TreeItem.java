package model.familyTree;

import java.time.LocalDate;
import java.util.List;

public interface TreeItem<E> {
  void setId(long id);
    long getId();
    E getFather();
    E getMother();
    boolean addChild(E human);
    boolean addParent(E human);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<E> getParents();
    List<E> getChildren();
    E getSpouse();
    void setSpouse(E human);
}
