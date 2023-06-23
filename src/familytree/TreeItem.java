package familytree;

import human.Human;

import java.util.List;

public interface TreeItem {
    int getId();
    String getName();
    int getAge();
    Human getFather();
    Human getMother();
//    List<TreeItem> getChildren();
    boolean  addChild(TreeItem child);
    String getInfo();







}
