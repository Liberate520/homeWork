package Hw.sem3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class FamilyTreeImpl<T> implements FamilyTree<T> {
    private T root;
    private List<T> members;

    public FamilyTreeImpl(T root) {
        this.root = root;
        members = new ArrayList<>();
        members.add(root);
    }

    @Override
    public void addChild(T parent, T child) {
        members.add(child);
    }

    @Override
    public List<T> getAllMembers() {
        return members;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        members.sort(comparator);
    }

    @Override
    public void saveToFile(DataStorage<T> dataStorage, String filename) {
        dataStorage.saveData(members, filename);
    }

    @Override
    public void loadFromFile(DataStorage<T> dataStorage, String filename) {
        members = dataStorage.loadData(filename);
    }
}