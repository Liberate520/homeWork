package familyTree.treeWorkspace;


import familyTree.treeComparators.ComparatorByAge;
import familyTree.treeComparators.ComparatorByGender;


import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public boolean addPerson(E person) {
        if (!familyTree.contains(person)){
        familyTree.add(person);
        return true;
        }
        return false;
    }

    public E getPerson(int id) {
        for (E p : familyTree) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    public int getMaxId(){
        int id = 0;
        if (familyTree.isEmpty()) return 0;
        for (E e:familyTree){
            if (e.getId() > id) id =e.getId();
        }
        return ++id;
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
