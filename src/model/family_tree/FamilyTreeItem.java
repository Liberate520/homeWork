package model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem {
    boolean addChild(FamilyTreeItem child);

    String getFirstName();

    String getLastName();

    LocalDate getBirthDate();

    LocalDate getDeathDate();

    FamilyTreeItem getMother();

    FamilyTreeItem getFather();

    List<FamilyTreeItem> getChildren();

    String getInfo();
}
