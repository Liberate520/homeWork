package family;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class IteratorHunan implements Iterator<Human> {
    private int index;
    private final List<Human> lstHuman;

    public IteratorHunan(List<Human> lstHuman) {
        this.lstHuman = lstHuman;
    }

    @Override
    public boolean hasNext() {
        return index < lstHuman.size();
    }

    @Override
    public Human next() {
        return lstHuman.get(index++);
    }
}
