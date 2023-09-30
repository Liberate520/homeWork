
import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree implements Iterable<Human> {
    private List<Human> members = new ArrayList<>();
    private Human root;

    public FamilyTree(Human root) {
        this.root = root;
        this.members.add(root);
    }

    public Human getRoot() {
        return root;
    }

    public void setRoot(Human root) {
        this.root = root;
        if (!members.contains(root)) {
            members.add(root);
        }
    }

    public void addMember(Human member) {
        if (!members.contains(member)) {
            members.add(member);
        }
    }

    public String getFamilyMembers() {
        return members.stream()
                .map(Human::toString)
                .collect(Collectors.joining("
"));
    }

    public List<Human> getMembers() {
        return members;
    }

    @Override
    public Iterator<Human> iterator() {
        return new BFSIterator(root);
    }

    private class BFSIterator implements Iterator<Human> {
        private final Queue<Human> queue = new LinkedList<>();

        public BFSIterator(Human start) {
            this.queue.add(start);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Human next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Human current = queue.poll();
            if (current.getChildren() != null) {
                queue.addAll(current.getChildren());
            }
            return current;
        }
    }
}
