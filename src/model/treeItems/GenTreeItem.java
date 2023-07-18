package model.treeItems;

import model.interfaces.Loadable;
import model.interfaces.Saveable;
import model.treeItems.enums.Gender;

public interface GenTreeItem extends Loadable, Saveable {
    void setParent(GenTreeItem item);
    void addChild(GenTreeItem item);

    void setHierarchyLevel(int level);
    int getHierarchyLevel();

    void setId(int id);
    int getId();

    int getAge();
    Gender getGender();
    String getFullName();
    String getFullInfo();
}