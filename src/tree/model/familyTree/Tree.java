package tree.model.familyTree;

import java.io.Serializable;
import java.util.List;

public interface Tree<T> extends Iterable<T>, Serializable {

    List<T> getFamilyTree();
    void sortByName();
    void sortByChild();
}
