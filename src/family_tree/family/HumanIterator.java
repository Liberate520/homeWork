package family_tree.family;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int index = 0;
    private List<Human> humanList;

    public HumanIterator(List<Human> familyMembersList) {
        humanList = familyMembersList;
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
