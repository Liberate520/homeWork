package java_oop_homeWork.src.model;

import java_oop_homeWork.src.model.familyTree.FamilyTree;

import java.util.Date;

public interface FamilyTreeItem {
    void setFamily(FamilyTree family);
    boolean setParent(FamilyTreeItem parent);
    void addChild(FamilyTreeItem child);
    int getID();
    String getInfo();
    String getName();
    Date getDateBirth();
    Sex getSex();
    boolean setMother(FamilyTreeItem mother);
    boolean setFather(FamilyTreeItem father);
}
