package FamilyTree.model;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeIterator<T extends TreeItem> implements Iterator<T> {
    private ArrayList<T> humanList;
    private int index = 0;
    public TreeIterator(ArrayList<T> family){
        humanList = family;
    }
    public boolean hasNext(){
        return index < humanList.size();
    }
    public T next(){
        return humanList.get(index++);
    }
}
