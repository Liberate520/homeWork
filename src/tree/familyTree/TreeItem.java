package tree.familyTree;

import tree.human.Human;
import java.util.Set;

public interface TreeItem {
    String getName();
    Object getFather();
    Object getMother();
    Set<Human> getChildrenList();
    void addChild(Object human);
    String getChild();
}
