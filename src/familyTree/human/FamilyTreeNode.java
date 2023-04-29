package familyTree.human;

import java.time.LocalDate;

public interface FamilyTreeNode {
    String getFullName();
    String getGender();
    LocalDate getDateOfBirth();
    void setDateOfBirth(String dateOfBirth);
    LocalDate getDateOfDeath();
    void setDateOfDeath(String dateOfDeath);
    int getAge();
    String getNameParents();
    String getSpouse();
    boolean setSpouse(String str);
    String getChildren();
    boolean setChild(String str);
}
