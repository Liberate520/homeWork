package family_tree.tree;

import family_tree.human.Human;
import family_tree.human.comparators.HumanComparatorByDateOfBirth;
import family_tree.human.comparators.HumanComparatorByLastName;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humans = new LinkedList<Human>();

    public void addHuman(Human human) {
       this.humans.add(human);
    }

    public List<Human> getHumans() {
        return this.humans;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: this.humans) {
            stringBuilder.append(this.humans.indexOf(human)+1);
            stringBuilder.append(") ");
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByDateOfBirth(){
      Collections.sort(humans, new HumanComparatorByDateOfBirth());
    }

    public void sortByFirstName(){
        Collections.sort(humans);
    }

    public void sortByLastName(){
        Collections.sort(humans, new HumanComparatorByLastName());
    }
    public Iterator<Human> iterator() {
        return new HumanIterator(this.humans);
    }
}
