package ru.gb.family_tree;

import java.util.List;

public interface TreeItem {
    String getFullName();
    int getAge();
    String getInfo();
    List<Human> getChildren();
    List<Human> getParents();
    void addChild(Human h);
}
