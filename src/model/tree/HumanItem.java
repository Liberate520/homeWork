package model.tree;

import java.time.LocalDate;
import java.util.List;

public interface HumanItem<T> {
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();
    String getAge();
    LocalDate getDateBorn();
    LocalDate getDateDeath();
    List<T> getParents();
    List<T> getChildren();
}