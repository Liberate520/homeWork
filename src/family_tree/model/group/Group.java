package family_tree.model.group;

import family_tree.model.group.iterators.GroupIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group<E> implements Iterable<E>, Serializable {
    List<E> listItem;
    public Group(){
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
        return new GroupIterator<>(listItem);   //return humans.iterator();
    }
}
