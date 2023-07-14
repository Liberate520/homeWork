package ru.java_oop.family_tree.family_tree;

import ru.java_oop.family_tree.human.Gender;

import java.util.List;

public interface FamilyTreeItem {
    String getName();
    int getAge();
    long getId();
    void setId(long id);
    void setParents(List<FamilyTreeItem> parents);
    void addParent(FamilyTreeItem parent);
    List<FamilyTreeItem> getParents();
    List<FamilyTreeItem> getChildren();
    void addChild(FamilyTreeItem child);
    FamilyTreeItem getSpouse();
    void setSpouse(FamilyTreeItem spouse);
    Gender getGender();
}
