package interfaces;

import treeItems.enums.Gender;

public interface GenTreeItem<T> extends Loadable, Saveable {
    void addChild(T item);
    void setFather(T item);
    void setMother(T item);

    void setHierarchyLevel(int level);
    int getHierarchyLevel();

    int getId();
    int getAge();
    Gender getGender();
    String getFullName();
    void showFullInfo();
}