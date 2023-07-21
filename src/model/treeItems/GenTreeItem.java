package model.treeItems;

import java.util.List;
import model.interfaces.Loadable;
import model.interfaces.Saveable;
import model.treeItems.enums.Gender;

public interface GenTreeItem extends Loadable, Saveable {
    void setBirthDate(int day, int month, int year) throws Exception;
    void setDeathDate(int day, int month, int year) throws Exception;

    void setParent(GenTreeItem item);
    void addChild(GenTreeItem item);

    void setHierarchyLevel(int level);
    int getHierarchyLevel();

    void setId(int id);
    int getId();

    int getFatherId();
    int getMotherId();
    List<Integer> getChildsIds();

    int getAge();
    Gender getGender();
    String getFullName();
    String getFullInfo();
}