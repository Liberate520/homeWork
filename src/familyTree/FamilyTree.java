package familyTree;

import person.Person;
import person.comparators.ComparatorByAge;
import person.comparators.ComparatorByName;

import java.io.Serializable;
import java.util.*;

/**
 * Все семейные связи решил хранить тут, а не в полях класса person.Person.
 * Смотрите familyTree.Connections.java.
 *
 * Методы сортировки возвращают TreeMap, а не исходную структуру.
 */
public class FamilyTree implements Serializable, Iterable<Map.Entry<Person, Connections>> {
    private HashMap<Person, Connections> family;

    public FamilyTree() {
        this.family = new HashMap<>();
    }

    public boolean addPerson(Person person) {
        if (!family.containsKey(person)) {
            Connections connections = new Connections();
            family.put(person, connections);
            return true;
        }
        return false;
    }

    public void oneWayConnection(Person connectFrom, ConnectionType key, Person connectTo) {
        if (family.containsKey(connectFrom))
            family.get(connectFrom).putConnections(key, connectTo);
    }

    /**
     * То же самое что сверху, но автоматически добавляется соответствующая обратная связь
     */
    public void putConnection(Person connectFrom, ConnectionType key, Person connectTo) {
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

    public boolean findConnection(Person connectFrom, Person connectTo) {
        Connections connections = family.get(connectFrom);
        return connections.find(connectTo);
    }

    public String showConnections(Person person) {
        return person + "\n" + "Близкие родственники:\n" +
                family.get(person);
    }

    public TreeMap<Person, Connections> sortByAge() {
        TreeMap<Person, Connections> result = new TreeMap<>(new ComparatorByAge());
        result.putAll(family);
        return result;
    }

    public TreeMap<Person, Connections> sortByName() {
        TreeMap<Person, Connections> result = new TreeMap<>(new ComparatorByName());
        result.putAll(family);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person :
                family.keySet()) {
            sb.append(person).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Map.Entry<Person, Connections>> iterator() {
        return family.entrySet().iterator();
    }
}
