package Hw.sem1;

import java.util.Comparator;
import java.util.List;

interface FamilyTreeInterface<T> {
    void setRoot(T root);
    void addChild(T parent, T child);
    List<T> getAllMembers();
    void sort(Comparator<T> comparator);
}
