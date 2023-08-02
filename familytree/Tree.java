package homeWork.familytree;

import java.util.*;

public class Tree<T> implements Iterable<T> {
    private Map<String, T> members;

    public Tree() {
        members = new HashMap<>();
    }

    public void addMember(String key, T member) {
        members.put(key, member);
    }

    // Other methods and iterator implementation...

    @Override
    public Iterator<T> iterator() {
        return members.values().iterator();
    }

    // Method to get all members as a list
    public List<T> getAllMembers() {
        return new ArrayList<>(members.values());
    }
}

