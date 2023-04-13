package human;

import java.util.*;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanList = new ArrayList<>();

    public HumanIterator(HashMap<Integer, Human> humanMap) {
        this.humanList.addAll(humanMap.values());
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
