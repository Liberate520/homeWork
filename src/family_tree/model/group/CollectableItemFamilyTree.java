package family_tree.model.group;

import java.util.Iterator;

public interface CollectableItemFamilyTree<E extends ItemFamilyTree<E>> extends Iterable<E>{
    public void add(E e);
    public String getInfo();
    public int getSize();
    public E getElementByIndex(int index);

    public void sortByName();
    public void sortByAge();
}
