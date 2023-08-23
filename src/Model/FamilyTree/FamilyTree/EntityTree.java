package Model.FamilyTree.FamilyTree;

import java.io.Serializable;

public interface EntityTree<E> extends Serializable {
    void addToList(E entity);

    E findById(int id);

    void sortByName();

    void sortByAge();

    void makeMarriage(E spouseOne, E spouseTwo);

    int getSize();

    String getInfoFamilyTree();
}
