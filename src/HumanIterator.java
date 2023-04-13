import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private ArrayList<Human> familyTree;

    public HumanIterator(ArrayList<Human> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public Human next() {
        return familyTree.get(index++);
    }
    
}