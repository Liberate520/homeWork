import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public boolean search;
    private List<Relation> tree = new ArrayList<>();

    public List<Relation> getTree() {
        return tree;
    }

    public void appendParent(Human parent, Human children) {
        tree.add(new Relation(parent, Relation.Relationship.PARENT, children));
        tree.add(new Relation(children, Relation.Relationship.CHILDREN, parent));
    }

    public void appendMariage(Human husband, Human wife) {
        tree.add(new Relation(husband, Relation.Relationship.MARIAGE, wife));
    }

    public List<Human> search(Human hum, Relation.Relationship node) {
        List<Human> result = new ArrayList<>();

        for (Relation item : tree) {
            if (item.getHuman1().equals(hum)
                    && item.getRelationship().equals(node)) {
                result.add(item.getHuman2());
            }
        }
        return result;
    }
}
