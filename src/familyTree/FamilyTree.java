package familyTree;
import Human.*;
import Service.*;
import Human.Comparators.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ItemOfFamilyTree> extends Saver implements Iterable<E> {
    private List<E> elementsList;

    public FamilyTree() {
        elementsList = new ArrayList<E>();
    }
    public void addHuman(E element) {
        elementsList.add(element);
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
    }

    public void sortByAge(){
        elementsList.sort(new ElementComparatorByAge<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<>(elementsList);
    }
}
