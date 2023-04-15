package familyTree;

import comporator.HumanComparatorById;
import comporator.HumanComparatorByLastName;
import human.Human;
import human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Human> implements Serializable, Iterable<E> {
    private final List<E> familyTree;

    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void add(E human) {
        this.familyTree.add(human);
    }

    @Override
    public String toString() {
        for (Human item : familyTree) {
            System.out.println(item);
        }
        return " ";
    }

    public void parentsHuman(E human) {
        E mather = null;
        E father = null;
        for (E item : familyTree) {
            if (item.getId() == human.getIdMather()) mather = item;
            if (item.getId() == human.getIdFather()) father = item;
        }
        System.out.printf("Исследуемый объект:\n%s\nМать - %s\nОтец - %s", human, mather, father);
    }

    public void childrensHuman(E human) {
        List<E> childrens = new ArrayList<>();
        for (E item : familyTree) {
            if (item.getIdFather() == human.getId() || item.getIdMather() == human.getId()) {
                childrens.add(item);
            }
        }
        if (childrens.size() > 0) {
            System.out.printf("\nИсследуемый объект:\n%s\nДети объекта:\n", human);
            for (E item : childrens) System.out.print(item);
        } else System.out.printf("\nИсследуемый объект:\n%s\nДетей нет", human);
    }
    @Override
    public Iterator<E> iterator() {

        return new HumanIterator<E>(familyTree);
    }

    public void sortByID() {
        familyTree.sort( new HumanComparatorById());
    }

    public void sortByLastName() {
        familyTree.sort( new HumanComparatorByLastName());
    }
}
