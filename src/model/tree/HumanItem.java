package model.tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface HumanItem<T> extends Serializable{
    T getFather();
    T getMother();
    void setId(long id);
    long getId();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();
    int getAge();
    LocalDate getDateBorn();
    LocalDate getDateDeath();
    List<T> getParents();
    List<T> getChildren();
}