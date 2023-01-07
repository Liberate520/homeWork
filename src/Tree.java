
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Tree implements Iterable, Serializable {
    private List<Human> tree;

    public Tree(List<Human> humans) {
        this.tree = humans;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public List<Human> getTree() {
        return tree;
    }

    public void setTree(List<Human> humans) {
        this.tree = humans;
    }

    public void addHuman(Human human) {
        tree.add(human);
    }

    public List<Human> getChildrens(Human human) {
        List<Human> chil = new ArrayList<>();
        for (Human item : tree) {
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
