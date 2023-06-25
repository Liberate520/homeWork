package Hw.sem3;

import java.util.Comparator;
import java.util.List;

interface FamilyTree<T> {
    void addChild(T parent, T child);

    List<T> getAllMembers();

    void sort(Comparator<T> comparator);

    void saveToFile(DataStorage<T> dataStorage, String filename);

    void loadFromFile(DataStorage<T> dataStorage, String filename);
}
