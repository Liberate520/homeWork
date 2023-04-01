package tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import human.Human;

public class FamilyTree implements Serializable, Tree {
    private int id;
    private List<Human> people;

    public FamilyTree(List<Human> people) {
        this.people = people;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<Human> getPeople() {
        return people;
    }

    public void addpeople(Human h, Human mh, Human fh) {
        if (mh != null)
            mh.addchildren(h);
        if (fh != null)
            fh.addchildren(h);
        h.setId(id++);
        people.add(h);
    }

    public Human findHuman(String str, Human nl) {
        for (Human item : people) {
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
    public Iterator<Human> iterator() {
        return new HumanIterator(this.people);
    }
}
