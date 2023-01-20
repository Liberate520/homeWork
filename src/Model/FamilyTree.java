package DZ1.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {

    private List<T> humans = new ArrayList<>();

    public FamilyTree(List<T> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public T getHumanByName(String name) {
        for (T human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public List<T> getHumans() {
        return humans;
    }

    public void setHumans(List<T> humans) {
        this.humans = humans;
    }

    @Override
    public Iterator<T> iterator() {

        return new FamilyTreeIterator<>(humans);
    }

}
