package family_tree;

import java.time.LocalDate;

public interface FamilyItem {
    LocalDate getDateOfBirth();
    String getName();
    void setId(int id);
    int getId();

}
