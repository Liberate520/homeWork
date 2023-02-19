import java.util.Iterator;
import java.util.ArrayList;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private ArrayList<Human> familyTree;

    public HumanIterator(ArrayList<Human> familyTree){
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
