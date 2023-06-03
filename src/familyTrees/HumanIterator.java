package familyTrees;

import human.Human;

import java.util.Iterator;
import java.util.function.Consumer;

public class HumanIterator implements Iterator<Human> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Human next() {
        return null;
    }
}
