package family_tree.model.tree;

public interface Group<E extends SentientEntity<E>> extends Iterable<E> {
    void addFamilyMember(E member);

    E getFamilyMember(int id);

    int getFamilySize();

    void clearFamily();

    void sortByName();

    void sortByAge();
}
