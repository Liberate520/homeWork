package family_tree.model.group;

import family_tree.model.group.comparators.ComparatorByAge;
import family_tree.model.group.comparators.ComparatorByName;
import family_tree.model.group.iterators.GroupIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupItemFamilyTree<E extends ItemFamilyTree<E>> implements CollectableItemFamilyTree<E>, Serializable {
    List<E> listItem;
    public GroupItemFamilyTree(){
        listItem = new ArrayList<>();
    }

    public void add(E e){
        listItem.add(e);
    }

    public String getInfo(){
        List<String> listResult = new ArrayList<>();
        for (E e : listItem)
            listResult.add(e.toString());
        return String.join("\n", listResult);
    }

    public int getSize(){
        return listItem.size();
    }

    public E getElementByIndex(int index){
        if(index < 0 || index >= listItem.size()) return null;
        return listItem.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return new GroupIterator<>(listItem);
    }
    public void sortByName(){
        listItem.sort(new ComparatorByName<>());
    }
    public void sortByAge(){
        listItem.sort(new ComparatorByAge<>());
    }
}