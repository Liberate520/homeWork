
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends Members> implements Serializable, Iterable {

    private List<E> tree;
    public Object iterator;

    public Tree(List<E> tree) {
        this.tree = tree;
    }

    public void setTree(List<E> humans) {
        this.tree = humans;
    }

    public void addHuman(E human) {
        tree.add(human);
    }

    public E getMember(int i) {
        return tree.get(i);
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

    public int findHumanIndx(String surname, String name) {

        for (E item : tree) {
            if (item.getName().equals(name) & item.getSurname().equals(surname)) {
                return tree.indexOf(item);
            }
        }
        return -1;
    }

    public int sizeTree() {
        return tree.size();
    }

    public void get(int i) {
        tree.get(0).toString();
    }

}
