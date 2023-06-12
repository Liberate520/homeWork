package model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> {
    boolean addChild(T child);

    String getFirstName();

    String getLastName();

    LocalDate getBirthDate();

    LocalDate getDeathDate();

    T getMother();

    T getFather();

    List<T> getChildren();

    String getInfo();
}
