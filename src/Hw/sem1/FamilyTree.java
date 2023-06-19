package Hw.sem1;

import java.io.Serializable;
import java.util.*;

class FamilyTree<T extends Person> implements Iterable<T>, Serializable {
    private T root;

    public FamilyTree(T root) {
        this.root = root;
    }

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }

    public void addChild(T parent, T child) {
        parent.addChild(child);
        child.setFather(parent);
    }

    public List<T> getAllMembers() {
        List<T> allMembers = new ArrayList<>();
        traverseTree(root, allMembers);
        return allMembers;
    }

    private void traverseTree(T person, List<T> allMembers) {
        allMembers.add(person);
        for (Person child : person.getChildren()) {
            traverseTree((T) child, allMembers);
        }
    }

    @Override
    public Iterator<T> iterator() {
        List<T> allMembers = getAllMembers();
        return allMembers.iterator();
    }

    public void sortByName() {
        List<T> allMembers = getAllMembers();
        Collections.sort(allMembers, Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        List<T> allMembers = getAllMembers();
        Collections.sort(allMembers, Comparator.comparing(Person::getBirthDate));
    }
}