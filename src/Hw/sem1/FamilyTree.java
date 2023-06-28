package Hw.sem1;

import java.util.*;

public class FamilyTree<T> implements FamilyTreeInterface<T> {
    private T root;
    private Map<T, List<T>> tree;

    public FamilyTree() {
        tree = new HashMap<>();
    }

    @Override
    public void setRoot(T root) {
        this.root = root;
    }

    @Override
    public void addChild(T parent, T child) {
        tree.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
    }

    @Override
    public List<T> getAllMembers() {
        List<T> members = new ArrayList<>();
        traverse(root, members);
        return members;
    }

    private void traverse(T node, List<T> members) {
        if (node == null) return;
        members.add(node);
        List<T> children = tree.get(node);
        if (children != null) {
            for (T child : children) {
                traverse(child, members);
            }
        }
    }

    @Override
    public void sort(Comparator<T> comparator) {
        List<T> members = getAllMembers();
        members.sort(comparator);
        Map<T, List<T>> sortedTree = new HashMap<>();
        for (T member : members) {
            if (tree.containsKey(member)) {
                sortedTree.put(member, tree.get(member));
            }
        }
        tree = sortedTree;
    }
}