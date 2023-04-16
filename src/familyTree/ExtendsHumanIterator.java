package familyTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import human.Human;

public class ExtendsHumanIterator<T extends Human<T>> implements Iterator<Human<T>> {
    private List<T> humanList = new ArrayList<>();;
    private int index;

    public ExtendsHumanIterator(Tree<T> Tree) {
        humanList = Tree.getTreeList();
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human<T> next() {
        return humanList.get(index++);
    }

}
