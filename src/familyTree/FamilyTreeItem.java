package familyTree;

import human.Gender;
import human.Human;

public interface FamilyTreeItem {

    int getId();
    String getFirstName();
    String getLastName();
    Gender getGender();
    Object getMother();
    Object getFather();
    String getBirthday();
    String getNumberOfChildren();

    void setChildren(Object item);
}
