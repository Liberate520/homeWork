package tree.familyTree;

import java.io.Serializable;
import java.util.List;

public interface Tree<T> extends Iterable<T>, Serializable {
    void addHuman(T human);
    List<T> getFamilyTree();
    void sortByName();
    void sortByChild();
}
