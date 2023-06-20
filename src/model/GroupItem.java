package model;

import java.time.LocalDate;
import java.util.List;

public interface GroupItem<T> {
    String getName();
    LocalDate getDate();
    T getMother();
    T getFather();
    List<T> getChildren();
    void addChild(T person);
    List<T> getParents();
}