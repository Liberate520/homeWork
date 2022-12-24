import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {



    FamilyTree tree = new FamilyTree();

    private  int index;
    private List<Human> famTree;

    public HumanIterator(List<Human> famTree) {
        this.famTree = famTree;
    }

    @Override
    public boolean hasNext() {
        return index < famTree.size();
    }

    @Override
    public Human next() {
        return famTree.get(index++);
    }
}