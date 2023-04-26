package FamilyTree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> allHumans;
    public HumanIterator(List<Human> allHumans){
        this.allHumans = allHumans;
    }

    @Override
    public boolean hasNext() {
        return index <allHumans.size();
    }

    @Override
    public Human next() {
        return allHumans.get(index++);
    }
}
