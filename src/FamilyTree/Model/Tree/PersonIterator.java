package family_tree.FamilyTree.Model.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonIterator<T> implements Iterator<T> {

    private int index;
    private List<T> familyTree;

    public PersonIterator(ArrayList<T> tree) {
        this.familyTree = tree;
    }

    @Override
    public boolean hasNext() {
        return index < this.familyTree.size();
    }

    @Override
    public T next() {

        return (T) familyTree.get(index++);
    }
}
