package genealogy_tree.genealogy_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class GenealogyTree<T> implements Serializable, Iterable<T> {
    private List<T> tree;

    public GenealogyTree() {
        tree = new ArrayList<>();
    }

    public void addElement(T element) {
        if (!tree.contains(element)) {
            tree.add(element);
            System.out.println("В дерево добавлен: " + element);
        } else {
            System.out.println("Не удалось добавить в дерево дубликат: " + element);
        }
    }

    public List<T> getTree() {
        return tree;
    }

    public List<T> getTreeSortedBy(Comparator<T> comparator) {
        List<T> result = new ArrayList<>(tree);
        Collections.sort(result, comparator);
        return result;
    }

    public void setTree(List<T> tree) {
        this.tree = tree;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenealogyTreeIterator<T>(tree);
    }    
}