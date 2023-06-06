package tree.familyTree;

import tree.familyTree.comparators.HumanComparatorByChildCount;
import tree.familyTree.comparators.HumanComparatorByName;
import tree.familyTree.iterators.HumanIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeItem<T>> implements Tree<T> {
    private List<T> familyTree;
    private String familyName;

    public FamilyTree(String familyName) {
        familyTree = new ArrayList<>();
        this.familyName = familyName;
    }

    public void addHuman(List<T> human) {
        for (T someHuman : human) {
            addHuman(someHuman);
        }
    }

    public void addHuman(T human) {
        familyTree.add(human);
        for (T someHuman : familyTree) {
            if (someHuman == human.getFather()) {
                someHuman.addChild(human);
            }
        }
        for (T someHuman : familyTree) {
            if (someHuman == human.getMother()) {
                someHuman.addChild(human);
            }
        }
    }

    public List<T> getFamilyTree() {
        return this.familyTree;
    }

    public void outFamily(T human) {
        familyTree.remove(human);
    }

    public T findHuman(String name) {
        for (T human : familyTree) {
            if (human.getName().equals(name)) return human;
        }
        return null;
    }

    public void sortByName() {
        getFamilyTree().sort(new HumanComparatorByName<>());
    }

    public void sortByChild() {
        getFamilyTree().sort(new HumanComparatorByChildCount<>());
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (T human : familyTree)
            st.append(", " + human.getName());
        return familyName + ": (" + st.toString().substring(2) + ")";
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(familyTree);
    }
}
