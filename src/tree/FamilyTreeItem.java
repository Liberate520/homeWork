package tree;

import human.Human;

import java.util.List;

public interface FamilyTreeItem  {
    List<FamilyTreeItem> getChildren();
    Human getMother();
    void addChild(FamilyTreeItem child);
    Human getFather();
    int getAge();
    String getFirstName();
    void setFather(FamilyTreeItem father);
    void setMother(FamilyTreeItem mother);
    String getInfo();
    String getLastName();
    Object getBrothers();
    Object getSisters();
}
