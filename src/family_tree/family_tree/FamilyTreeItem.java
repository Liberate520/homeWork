package family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    // void setId(int id);
    // int getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    boolean addSpouse (T human);
    String getName();
    LocalDate getBirthDate();
    LocalDate getDethDate();
    List<T> getParents();
    List<T> getChildren();
    List<T> getSpouse();
    void setSpouse(T human);
    // void fileHandler();
    // void FamilyTree();

}