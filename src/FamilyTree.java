import java.util.ArrayList;
import java.util.List;

class FamilyTree {
    private Person root;

    public FamilyTree(Person root) {
        this.root = root;
    }

    public Person getRoot() {
        return root;
    }

    public List<Relationship> getAllRelationships() {
        List<Relationship> allRelationships = new ArrayList<>();
        collectRelationships(root, allRelationships);
        return allRelationships;
    }

    private void collectRelationships(Person person, List<Relationship> relationships) {
        relationships.addAll(person.getRelationships());
        for (Person child : person.getChildren()) {
            collectRelationships(child, relationships);
        }
    }
}