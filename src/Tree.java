
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends Members> implements Iterable, Serializable {

    private List<E> tree;

    public Tree(List<E> humans) {
        this.tree = humans;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public List<E> getTree() {
        return tree;
    }

    public void setTree(List<E> humans) {
        this.tree = humans;
    }

    public void addHuman(E human) {
        tree.add(human);
    }

    public List<E> getChildrens(E human) {
        List<E> chil = new ArrayList<>();
        for (E item : tree) {
            if (item.getFather() == human || item.getMother() == human) {
                chil.add(item);
            }
        }
        return chil;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator(tree);
    }

    public void sortBySurname() {
        Collections.sort(tree, new TreeComparator());
    }

    public void sortByDate() {
        Collections.sort(tree);
    }

}
