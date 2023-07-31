package tree;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import model.Person;


public class GenealogyTree<T> implements Iterable<T>, Serializable {
    private T root;
    private Map<T, List<T>> familyTree;

    public GenealogyTree(T root) {
        this.root = root;
        familyTree = new HashMap<>();
        familyTree.put(root, new ArrayList<>());
    }

    public void addParentChildRelation(T parent, T child) {
        if (!familyTree.containsKey(parent) || !familyTree.containsKey(child)) {
            throw new IllegalArgumentException("Один из указанных элементов не присутствует в дереве.");
        }
        familyTree.get(parent).add(child);
    }

    public List<T> getChildren(T person) {
        return familyTree.getOrDefault(person, new ArrayList<>());
    }

    public List<T> getAncestors(T person) {
        List<T> ancestors = new ArrayList<>();
        getAncestorsRecursive(person, ancestors);
        return ancestors;
    }

    private void getAncestorsRecursive(T person, List<T> ancestors) {
        for (T parent : familyTree.keySet()) {
            if (familyTree.get(parent).contains(person)) {
                ancestors.add(parent);
                getAncestorsRecursive(parent, ancestors);
            }
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new GenealogyTreeIterator(root);
    }

    private class GenealogyTreeIterator implements Iterator<T> {
        private Queue<T> queue;

        public GenealogyTreeIterator(T root) {
            queue = new LinkedList<>();
            queue.add(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Дерево пустое.");
            }
            T current = queue.poll();
            queue.addAll(familyTree.getOrDefault(current, new ArrayList<>()));
            return current;
        }
    }

    private String getName(T entity) {
        return ((Person) entity).getPersonName();
    }

    public Person getRoot() {
        return null;
    }

    public List<T> sortChildrenByName(T person) {
        List<T> children = getChildren(person);
        children.sort(Comparator.comparing(this::getName));
        return children;
    }

    public List<T> sortAncestorsByName(T person) {
        List<T> ancestors = getAncestors(person);
        ancestors.sort(Comparator.comparing(this::getName));
        return ancestors;
    }

    public void saveToFile(String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(this);
            System.out.println("Дерево успешно сохранено в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении дерева в файл: " + e.getMessage());
            }
    }

    public static GenealogyTree<?> loadFromFile(String filePath) {
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
                    GenealogyTree<?> tree = (GenealogyTree<?>) inputStream.readObject();
                    System.out.println("Дерево успешно загружено из файла.");
                    return tree;
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Ошибка при загрузке дерева из файла: " + e.getMessage());
                }
                return null;
    }


}

