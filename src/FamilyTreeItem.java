package java_oop_homeWork.src;

import java_oop_homeWork.src.familyTree.FamilyTree;
import java_oop_homeWork.src.kinsman.Kinsman;
import java_oop_homeWork.src.kinsman.Sex;

import java.util.Date;
import java.util.Locale;

public interface FamilyTreeItem {
    void setFamily(FamilyTree family);
    boolean setParent(FamilyTreeItem parent);
    void addChild(FamilyTreeItem child);
    String getInfo();
    String getName();
    Date getDateBirth();
    Sex getSex();
    boolean setMother(FamilyTreeItem mother);
    boolean setFather(FamilyTreeItem father);
}
