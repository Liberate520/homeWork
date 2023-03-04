import java.util.ArrayList;
import java.util.Iterator;

class HumanIterator implements Iterator<Human>{

    private int index;
    private ArrayList<Human> familyTree;

    public HumanIterator(ArrayList<Human> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > index;

    }

    @Override
    public Human next() {
        return familyTree.get(index++);
    }

    
}