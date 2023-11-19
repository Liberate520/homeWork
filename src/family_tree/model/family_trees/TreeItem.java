package family_tree.model.family_trees;

import java.util.List;

public interface TreeItem<T> {
    String getName();
    int getAge();
    int setID(int id);
    List<T> getParents();
    void addChild(T child);
    void addMother(T mother);
    void addFather(T father);
}
