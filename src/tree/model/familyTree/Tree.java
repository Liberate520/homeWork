package tree.model.familyTree;

import tree.model.human.Gender;

import java.io.Serializable;
import java.util.List;

public interface Tree<T> extends Iterable<T>, Serializable {
    List<T> getFamilyTree();
    public void addHuman(T human);
    void sortByName();
    void sortByChild();
}
