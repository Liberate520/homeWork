package FamilyTree.interfaces;

import FamilyTree.Human;

import java.util.ArrayList;

public interface TreeItem {
    void addChild(TreeItem child);

    TreeItem getFather();

    TreeItem getMother();

    String getName();

    int getAge();

    ArrayList<Human> getChildrens();
}
