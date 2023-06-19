package model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> {
    boolean addChild(T child);

    String getFirstName();

    String getLastName();

    String getFirstMomName();

    String getLastMomName();

    String getFirstDadName();

    String getLastDadName();

    LocalDate getBirthDate();

    LocalDate getDeathDate();

    List<T> getChildren();

    String getInfo();

    String getNotFoundInfo();
}
