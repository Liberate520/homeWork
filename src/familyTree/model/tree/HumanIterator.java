package familyTree.model.tree;

import java.util.Iterator;
import java.util.Map;

public class HumanIterator<T> implements Iterator<T> {

    private Map<String, T> wholeGenus;
    private String key;
    private int index;

    public HumanIterator(Map<String, T> wholeGenus){
        this.wholeGenus = wholeGenus;
    }

    @Override
    public boolean hasNext() {
        return index < wholeGenus.size();
    }

    @Override
    public T next() {
        return wholeGenus.get(key);
    }
}
