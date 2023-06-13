package FamilyTree.model;

import java.util.ArrayList;

public interface TreeItem {
    void addChild(TreeItem child);

    TreeItem getFather();

    TreeItem getMother();

    String getName();

    int getAge();
    String getGender();

    ArrayList<Human> getChildrens();
}
