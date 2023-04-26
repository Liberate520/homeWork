package familyTree.tree;

import familyTree.human.Human;

import java.util.Iterator;
import java.util.Map;

public class HumanIterator implements Iterator<Human> {

    private Map<String, Human> wholeGenus;
    private Map<String, FamilyTree> treeMap;
    private String key;
    private int index;

    public HumanIterator(Map<String, Human> wholeGenus){
        this.wholeGenus = wholeGenus;
    }

    @Override
    public boolean hasNext() {
        return index < wholeGenus.size();
    }

    @Override
    public Human next() {
        return wholeGenus.get(key);
    }
}
