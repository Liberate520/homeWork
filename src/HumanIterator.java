import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator implements Iterable<Human> {
    private ArrayList<Human> tree;

    public HumanIterator(ArrayList<Human> tree) {
        this.tree = tree;
    }

    public HumanIterator(FamilyTree tree) {
        this(tree.getTree());
    }

    @Override
    public Iterator<Human> iterator() {
        return this.tree.iterator();
    }
    
}