package model.tree;

import model.Human.Human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Human> implements Serializable, Iterable<E> {
    private final List<E> tree;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }

    public void add(E o) {
        this.tree.add(o);
    }

    public List<E> searchForSurnameAndName(String surname, String name) {
        List<E> temp = new ArrayList<>();
        for (Human item : tree) {
            if (item.getName().equals(name) && item.getSurname().equals(surname)) {
                temp.add((E) item);
                if (item.getFather() != null && item.getMother() != null) {
                    temp.add((E) item.getFather());
                    temp.add((E) item.getMother());
                }
            }
        }
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(tree);
    }

    public List<E> getTree() {
        return tree;
    }
}
