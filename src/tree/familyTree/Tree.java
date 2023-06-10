package tree.familyTree;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface Tree<T> extends Iterable<T>, Serializable {

    void addHuman(T human);
    List<T> getFamilyTree();
    void sortByName();
    void sortByChild();
    T findHuman(String name) throws ClassNotFoundException, IOException;

}
