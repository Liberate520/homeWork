package tree.familyTree;

import java.util.List;

public interface Tree<T> extends Iterable<T>{
    void setFamily(T human);
    List<T> getFamilyTree();
    void sortByName();
    void sortByChild();
}
