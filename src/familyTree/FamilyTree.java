package familyTree;

import human.comparators.HumanComparatorByGender;
import human.comparators.HumanComparatorByName;
import human.comparators.HumansComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> familyTree;

//    public familyTree.FamilyTree(List<human.Human> humans) {
//        this.humans = humans;
//    }

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }



    /**
     * Метод возвращающий Коллекцию типа List
     */
    public List<E> getFamilyTree() {
        return familyTree;
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(this.familyTree);
    }


    public void sortByName() {
        familyTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        familyTree.sort(new HumansComparatorByAge<>());
    }

    public void sortByGender(){
        familyTree.sort(new HumanComparatorByGender<>());
    }
}
