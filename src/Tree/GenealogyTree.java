package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenealogyTree {
    private Person root;
    private Map<Person, List<Person>> parents;
    private Map<Person, List<Person>> children;

    public GenealogyTree(Person root) {
        this.root = root;
        parents = new HashMap<>();
        children = new HashMap<>();
    }

    public void addParent(Person child, Person father, Person mother) {
        if (!parents.containsKey(child)) {
            parents.put(child, new ArrayList<>());
        }
        parents.get(child).add(father);
        parents.get(child).add(mother);
    }

    public void addChild(Person parent, Person child) {
        if (!children.containsKey(parent)) {
            children.put(parent, new ArrayList<>());
        }
        children.get(parent).add(child);
    }

    public List<Person> getParents(Person child) {
        if (parents.containsKey(child)) {
            return parents.get(child);
        }
        return new ArrayList<>();
    }

    public List<Person> getChildren(Person parent) {
        if (children.containsKey(parent)) {
            return children.get(parent);
        }
        return new ArrayList<>();
    }

    public Person getRoot() {
        return root;
    }
}