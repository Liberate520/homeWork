package family_tree.Model.familyTree.iterator;

import java.util.Iterator;
import java.util.List;

import family_tree.Model.familyTree.TreeItem;

public class ItemIterator<E extends TreeItem<E>> implements Iterator<E> {
    private int index;
    private List<E> itemList;

    public ItemIterator(List<E> itemlist) {
        this.itemList = itemlist;
    }

    @Override
    public boolean hasNext() {
        return itemList.size() > index;
    }

    @Override
    public E next() {
        return itemList.get(index++);
    }
    
}
