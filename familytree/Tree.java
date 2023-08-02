package homeWork.familytree;

import java.util.*;

public class Tree implements Iterable<Human> {
    private Map<String, Human> members;

    public Tree() {
        members = new HashMap<>();
    }

    public void addMember(Human human) {
        members.put(human.getName(), human);
    }

    // Other methods remain unchanged...

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator();
    }

    // Custom iterator class for Tree
    private class FamilyTreeIterator implements Iterator<Human> {
        private Iterator<Human> iterator;

        public FamilyTreeIterator() {
            List<Human> sortedMembers = new ArrayList<>(members.values());
            sortedMembers.sort(Comparator.comparing(Human::getName));
            iterator = sortedMembers.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Human next() {
            return iterator.next();
        }
    }
}


