package OopJava.Service;

import OopJava.Human.Comparators.ComparatorByAge;
import OopJava.Human.Comparators.ComparatorByYear;
import OopJava.Human.Human;
import OopJava.Tree.FamilyTree;

import java.util.Collections;
public class Service<E extends Human> {
    private FamilyTree<E> tree;

    public Service(FamilyTree<E> tree) {
        this.tree = tree;
    }

    public void sortByName() {
        Collections.sort(tree.getPersonList(), new ComparatorByAge());
    }

    public void sortByYear() {
        Collections.sort(tree.getPersonList(), new ComparatorByYear());
    }
}
