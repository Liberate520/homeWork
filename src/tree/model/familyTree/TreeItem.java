package tree.model.familyTree;

import java.util.Set;

public interface TreeItem<T> {
    String getName();
    T getFather();
    T getMother();
    Set<T> getChildrenList();
    void addChild(T human);
    String getChild();
}
