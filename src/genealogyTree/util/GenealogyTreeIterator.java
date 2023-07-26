package util;

import java.util.ArrayDeque;
import java.util.Iterator;

import model.Person;

public class GenealogyTreeIterator implements Iterator<Person>, Iterator<Person> {
    private ArrayDeque<Person> queue;

    public GenealogyTreeIterator(Person root) {
        queue = new ArrayDeque<>();
        queue.add(root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Person next() {
        if (!hasNext()) {
            throw new RuntimeException("Дерево пустое.");
        }
        Person current = queue.poll();
        queue.addAll(current.getChildren());
        return current;
    }
}
