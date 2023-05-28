package FamilyTree;

import model.human.Human;

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
    int getId();
}
