package tree.familyTree;

import tree.familyTree.iterators.HumanIterator;
import tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Tree {
    private List<Human> familyTree;
    private String familyName;

    public FamilyTree(String familyName) {
        familyTree = new ArrayList<>();
        this.familyName = familyName;
    }

    public void setFamily(List<Human> human) {
        for (Human someHuman : human) {
            setFamily(someHuman);
        }
    }

    public void setFamily(Human human) {
        familyTree.add(human);
        for (Human someHuman : familyTree) {
            if (someHuman == human.getFather()) {
                someHuman.addChild(human);
            }
        }
        for (Human someHuman : familyTree) {
            if (someHuman == human.getMother()) {
                someHuman.addChild(human);
            }
        }
    }

    public List<Human> getFamilyTree() {
        return this.familyTree;
    }

    public void outFamily(Human human) {
        familyTree.remove(human);
    }

    public Human findHuman(String name) {
        for (Human human : familyTree) {
            if (human.getName().equals(name)) return human;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (Human human : familyTree)
            st.append(", " + human.getName());
        return familyName + ": (" + st.toString().substring(2) + ")";
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }
}
