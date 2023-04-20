package homeWork.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {
    private Map<Human, List<Human>> familyTree;

    public FamilyTree() {
        this.familyTree = new HashMap<>();
    }

    public void addParent(Human parent, Human child) {
        child.setParent(parent);
        if (familyTree.containsKey(parent)) {
            familyTree.get(parent).add(child);
        } else {
            List<Human> children = new ArrayList<>();
            children.add(child);
            familyTree.put(parent, children);
        }
    }

    public void addSibling(Human sibling1, Human sibling2) {
        if (!familyTree.containsKey(sibling1.getParent()) || !familyTree.containsKey(sibling2.getParent())) {
            throw new IllegalArgumentException("Оба брата и сестра должны иметь одного родителя в семейном древе.");
        }
        List<Human> siblings = familyTree.get(sibling1.getParent());
        if (!siblings.contains(sibling1) || !siblings.contains(sibling2)) {
            throw new IllegalArgumentException("Оба брата и сестра должны иметь одного родителя в семейном древе.");
        }
        if (!sibling1.equals(sibling2) && !siblings.contains(sibling2)) {
            siblings.add(sibling2);
        }
    }

    public List<Human> getChildren(Human parent) {
        if (familyTree.containsKey(parent)) {
            return familyTree.get(parent);
        } else {
            return null;
        }
    }
}
