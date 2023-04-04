package tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import human.Human;

public class FamilyTree<E extends Human> implements Serializable, Tree<E> {
    private int id;
    private List<E> people;

    public FamilyTree(List<E> people) {
        this.people = people;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<E> getPeople() {
        return people;
    }

    public void addpeople(E h, E mh, E fh) {
        if (mh != null)
            mh.addchildren(h);
        if (fh != null)
            fh.addchildren(h);
        h.setId(id++);
        people.add(h);
    }

    public E findHuman(String str, E nl) {
        for (E item : people) {
            if (str.toLowerCase().equals(item.getName().toLowerCase())) {
                return item;
            }
        }
        return nl;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.people);
        return str.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<E>(this.people);
    }
}
