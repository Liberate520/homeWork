import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> familyTree;
    public TreeIterator(List<Human> familyTree){
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
