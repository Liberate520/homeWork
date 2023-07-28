package family_tree.model.tree;

public interface Group_Info<E extends SentientEntity<E>> {
    String getSiblings(E child);
}
