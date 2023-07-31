package model.familyTree;

import model.person.comparators.ComparatorByAge;
import model.person.comparators.ComparatorByName;

import java.io.Serializable;
import java.util.*;

/**
 * Все семейные связи решил хранить тут, а не в полях класса model.person.Person.
 * Смотрите model.familyTree.Connections.java.
 * Методы сортировки возвращают TreeMap, а не исходную структуру.
 */
public class FamilyTree<T extends TreeNode<T>> implements Serializable, Iterable<Map.Entry<T, Connections<T>>> {
    private HashMap<T, Connections<T>> family;

    public FamilyTree() {
        this.family = new HashMap<>();
    }

    public boolean addPerson(T person) {
        if (!family.containsKey(person)) {
            Connections<T> connections = new Connections<>();
            family.put(person, connections);
            return true;
        }
        return false;
    }

    public void oneWayConnection(T connectFrom, ConnectionType key, T connectTo) {
        if (family.containsKey(connectFrom))
            family.get(connectFrom).putConnections(key, connectTo);
    }

    /**
     * То же самое что сверху, но автоматически добавляется соответствующая обратная связь
     */
    public void putConnection(T connectFrom, ConnectionType key, T connectTo) {
        oneWayConnection(connectFrom, key, connectTo);
        if (!findConnection(connectTo, connectFrom)) {
            switch (key) {
                case SIBLING -> oneWayConnection(connectTo, ConnectionType.SIBLING, connectFrom);
                case SPOUSE -> oneWayConnection(connectTo, ConnectionType.SPOUSE, connectFrom);
                case CHILD -> oneWayConnection(connectTo, ConnectionType.PARENT, connectFrom);
                case PARENT -> oneWayConnection(connectTo, ConnectionType.CHILD, connectFrom);
            }
        }
    }

    public boolean findConnection(T connectFrom, T connectTo) {
        Connections<T> connections = family.get(connectFrom);
        return connections.find(connectTo);
    }

    public String showConnections(T person) {
        return person + "\n" + "Близкие родственники:\n" +
                family.get(person);
    }

    public TreeMap<T, Connections<T>> sortByAge() {
        TreeMap<T, Connections<T>> result = new TreeMap<>(new ComparatorByAge());
        result.putAll(family);
        return result;
    }

    public TreeMap<T, Connections<T>> sortByName() {
        TreeMap<T, Connections<T>> result = new TreeMap<>(new ComparatorByName());
        result.putAll(family);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T person :
                family.keySet()) {
            sb.append(person).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Map.Entry<T, Connections<T>>> iterator() {
        return family.entrySet().iterator();
    }
}
