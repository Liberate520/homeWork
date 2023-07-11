package family_tree.tree;

import family_tree.creatures.comparators.CreaturesComparatorByDateOfBirth;
import family_tree.creatures.interfaces.Creatures;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class FamilyTree<E extends Creatures> implements Serializable, Iterable<E> {
    private List<E> tree = new LinkedList<>();

    public void addCreature(E creature) {
       this.tree.add(creature);
    }

    public List<E> getFamilyTree() {
        return this.tree;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E creature: this.tree) {
            stringBuilder.append(this.tree.indexOf(creature)+1);
            stringBuilder.append(") ");
            stringBuilder.append(creature.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByDateOfBirth(){
      Collections.sort(this.tree, new CreaturesComparatorByDateOfBirth<>());
    }

    public Iterator<E> iterator() {
        return new CreaturesIterator(this.tree);
    }
}
