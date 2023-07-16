package family_tree.model.tree.tree_service;


import java.io.Serializable;
import java.util.List;

public interface TreeItem<T> extends Serializable {
    int getAge();
    long getId();
    String getFullName();
    T getSpouse();
    void  setSpouse(T human);
    List<T> getParents();
    void setId(long id);
    boolean addChild (T child);
    List<T> getChildren();
    boolean addParent (T parent);
}
