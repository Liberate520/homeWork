package family_tree.human_family;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanGroup<T extends HumanItem> implements Iterable<T> {
    private List<T> humanList;

    public HumanGroup() {
        humanList = new ArrayList<>();
    }

    public void addHuman(T human) {
        humanList.add(human);
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(humanList);
    }

}
