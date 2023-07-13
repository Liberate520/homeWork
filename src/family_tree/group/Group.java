package family_tree.group;

import family_tree.group.iterators.GroupIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group<E> implements Iterable<E>, Serializable {
    protected List<E> listItem;
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

    @Override
    public Iterator<E> iterator() {
        return new GroupIterator<>(listItem);   //return humans.iterator();
    }
}
