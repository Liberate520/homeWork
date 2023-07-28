package treeWorkspace;


import enums.Gender;
import treeComparators.ComparatorByAge;
import treeComparators.ComparatorByGender;


import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> {
    // Класс для хранения и обработки списка людей в семейном дереве
    private List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addPerson(E person) {
        familyTree.add(person);
    }

    public E getPerson(int id) {
        for (E p : familyTree) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void sortByName() {
        Collections.sort(familyTree);
    }

    public void sortByAge() {
        Collections.sort(familyTree, new ComparatorByAge<>());
    }

    public void sortByGender() {
        Collections.sort(familyTree, new ComparatorByGender<>());
    }
    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (E e:familyTree){
            sb.append(e);
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return familyTree.iterator();
    }

}
