import java.util.ArrayList;
import java.util.Iterator;

public class MyTree implements Trees, Iterable<Nodes> {

    private ArrayList<Nodes> tree = new ArrayList<Nodes>();

    public ArrayList<Nodes> getTree() {
        return tree;
    }

    public void append(Persons parent, Persons child) {

        tree.add(new Nodes(parent, child, Relationships.PARENT));
        tree.add(new Nodes(child, parent, Relationships.CHILDREN));

    }

    @Override
    public ArrayList<Nodes> getData() {
        return tree;
    }

    @Override
    public Iterator<Nodes> iterator() {
        return tree.iterator();
    }

}
