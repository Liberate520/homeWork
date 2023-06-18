package FamilyTree.model.familyTree;

import java.util.ArrayList;
import java.util.Iterator;
public class TreeIterator<T extends TreeItem> implements Iterator<T> {
    private ArrayList<T> list;
    private int index;
    public TreeIterator(ArrayList<T> list){
        this.list = list;
        index = 0;
    }
    public boolean hasNext(){
        return index < list.size();
    }
    public T next(){
        return list.get(index++);
    }
}
