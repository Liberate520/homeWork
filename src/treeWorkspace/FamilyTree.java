package treeWorkspace;


import enums.Gender;
import interfaces.TreeItem;


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
        Collections.sort(familyTree, Comparator.comparingInt(TreeItem::getAge));
    }

    public void sortByGender() {
        Collections.sort(familyTree, (p1, p2) -> {
            if (p1.getGender().equals(p2.getGender())) {
                return 0;
            } else if (p1.getGender().equals(Gender.Male)
                    && p2.getGender().equals(Gender.Female)) {
                return 1;
            }
            return -1;
        });
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
