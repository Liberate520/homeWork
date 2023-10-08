package family_tree;

import java.time.LocalDate;

public interface FamilyTreeItem {
    void setId(int i);
    int getId();
    String getName();
    LocalDate getBirthDate();
}
