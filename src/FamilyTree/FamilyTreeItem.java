package FamilyTree;

import human.Human;

import java.util.List;

public interface FamilyTreeItem {
    String getFirstName();

    String getLastName();
    String getFullName();
    String getFull();
    String getChildrenInfo();
    String getFatherInfo();
    String getMotherInfo();
    String getInfo();
    Human getFather();
    Human getMother();
}
