package model.fmilyTree;
import model.service.Saver;
import model.fmilyTree.comparators.ElementComparatorByAge;
import model.fmilyTree.comparators.ElementComparatorByName;
import model.fmilyTree.comparators.ElementIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ItemOfFamilyTree> extends Saver implements Iterable<E> {
    private List<E> elementsList;

    public FamilyTree() {
        elementsList = new ArrayList<>();
    }
    public void addHuman(E element) {
        elementsList.add(element);
        System.out.println(getElementList());
    }

    public void setElementsList(List<E> elementsList) {
        this.elementsList = elementsList;
    }
    public List<E> getElementList () {
        return elementsList;
    }

    public E findByName(String name) {
        for (E element: elementsList) {
            if (element.getName().equalsIgnoreCase(name)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        for (E element: elementsList) {
            stringbuilder.append(element).append("\n");
        }
        return stringbuilder.toString();
    }

    public void sortByName() {
        elementsList.sort(new ElementComparatorByName<>());
        System.out.println(getElementList());
    }

    public void sortByAge(){
        elementsList.sort(new ElementComparatorByAge<>());
        System.out.println(getElementList());
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<>(elementsList);
    }
}
