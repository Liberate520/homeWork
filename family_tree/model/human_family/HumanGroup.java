package family_tree.model.human_family;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanGroup<Human> implements Iterable<Human> {
    private List<Human> humanList;

    public HumanGroup() {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

}
