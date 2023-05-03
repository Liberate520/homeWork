package familyTree;

import human.Gender;

public interface FamilyTreeItem {

    int getId();
    String getFirstName();
    String getLastName();
    Gender getGender();
    FamilyTreeItem getMother();
    FamilyTreeItem getFather();
    String getBirthday();
    String getNumberOfChildren();
    void setChildren(Object item);
}
