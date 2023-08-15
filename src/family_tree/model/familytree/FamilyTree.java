package family_tree.model.familytree;

import family_tree.model.comparators.ComparatorByAge;
import family_tree.model.comparators.ComparatorByGender;
import family_tree.model.comparators.ComparatorByName;
import family_tree.model.human.HumanIterator;
import family_tree.model.subject.Subject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree<E extends Subject> implements Serializable, Iterable<E> {
    private List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addSubject(E human) {
        familyTree.add(human);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }

    public void sortByAge() {
        familyTree.sort(new ComparatorByAge<>());
    }

    public void sortByGender() {
        familyTree.sort(new ComparatorByGender<>());
    }

    public void sortByName() {
        familyTree.sort(new ComparatorByName<>());
    }

}