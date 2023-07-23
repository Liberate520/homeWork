package familyTree;

import person.Person;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Все семейные связи решил хранить тут, а не в полях класса person.Person.
 * Смотрите familyTree.Connections.java.
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
