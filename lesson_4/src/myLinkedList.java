import java.util.LinkedList;

public class myLinkedList implements Queue {
    private LinkedList<Integer> list;

    public myLinkedList() {
        list = new LinkedList<>();
    }

    @Override
    public void enqueue(int num) {
        list.add(num);
    }

    @Override
    public int dequeue() {
        return list.pollFirst();
    }

    @Override
    public int first() {
        return list.getFirst();
    }

}
