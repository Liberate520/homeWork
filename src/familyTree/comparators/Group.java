package familyTree.comparators;

import java.util.List;

public interface Group<T> extends Iterable<T> {
    boolean add(T member);
    boolean remove(T member);

    List<T> getMembers();
    T getRoot();

    void setRoot(T root);
    String getInfo();
}
