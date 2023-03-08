package Java_OOP.homeWork;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int index;
    private List<Human> hum;

    public HumanIterator(List<Human> hum) {
        this.hum = hum;
    }

    @Override
    public boolean hasNext() {
        return hum.size() > index;
    }

    @Override
    public Human next() {
        return hum.get(index++);
    }

}
