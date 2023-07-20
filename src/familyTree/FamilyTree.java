package familyTree;

import person.Person;

public class FamilyTree {
    private Person root;

    public FamilyTree(Person root) {
        this.root = root;
    }

    public Person getRoot() {
        return root;
    }
}
