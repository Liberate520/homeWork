package family_tree.model.tree;

import family_tree.model.creatures.comparators.CreaturesComparatorByAge;
import family_tree.model.creatures.comparators.CreaturesComparatorByDateOfBirth;
import family_tree.model.creatures.comparators.CreaturesComparatorById;
import family_tree.model.creatures.interfaces.Creatures;

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

    public String viewAllFamily (int id){
        for (E creature: this.tree){
            if (creature.getId()==id)
            {
                return creature.viewAllFamily();
            }
        }
        return "Вы ввели неверное значение!";
    }
    public void sortById(){
        Collections.sort(this.tree, new CreaturesComparatorById<>());
    }
    public void sortByDateOfBirth(){
      Collections.sort(this.tree, new CreaturesComparatorByDateOfBirth<>());
    }
    public void sortByDateOfAge(){
        Collections.sort(this.tree, new CreaturesComparatorByAge<>());
    }
    public Iterator<E> iterator() {
        return new CreaturesIterator(this.tree);
    }
}
