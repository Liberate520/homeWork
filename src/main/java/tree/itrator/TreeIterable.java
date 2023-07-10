package tree.itrator;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterable implements Iterator<Human> {
    private int index;
    private List<Human> familyList;

    public TreeIterable(List<Human> familyList){
        this.familyList = familyList;
    }
    @Override
    public boolean hasNext() {
        return index < familyList.size();
    }

    @Override
    public Human next() {
        return familyList.get(index++);
    }
}
