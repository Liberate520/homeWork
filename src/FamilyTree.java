import java.util.HashSet;
import java.util.LinkedHashMap;

public class FamilyTree {
    private LinkedHashMap<HashSet<Parent>, HashSet<Children>> tree;

    FamilyTree() {
        this.tree = new LinkedHashMap<HashSet<Parent>, HashSet<Children>>();
    }

    public void put(Parent p1, Parent p2, Children child) {
        p1.addChildrens(child);
        p2.addChildrens(child);
        child.addParent(p1, p2);

        HashSet<Parent> parenst = new HashSet<Parent>();
        parenst.add(p1);
        parenst.add(p2);
        HashSet<Children> c = new HashSet<Children>();
        if (this.tree.containsKey(parenst) == false) this.tree.put(parenst, c);
        this.tree.get(parenst).add(child);
    }

    public void put(Human p1, Human p2, Human child) {
        Parent parent1 = new Parent(p1);
        Parent parent2 = new Parent(p2);
        Children c = new Children(child, parent1, parent2);
        put(parent1, parent2, c);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (HashSet<Parent> parents : this.tree.keySet()) {
            result.append(parents + "\n");
            for (Children children : this.tree.get(parents)) {
                result.append("\t" + children + "\n");
            }
        }

        return result.toString();
    }

}