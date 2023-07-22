package familyTree;

import person.Person;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Класс типа данных, в котором хранятся все родственные связи конкретного человека.
 */
public class Connections implements Serializable {
    private HashMap<ConnectionType, HashSet<Person>> connections;

    public Connections(ConnectionType key, Person person) {
        HashMap<ConnectionType, HashSet<Person>> connection = new HashMap<>();
        HashSet<Person> set = new HashSet<>();
        set.add(person);
        connection.put(key, set);
        this.connections = connection;
    }

    public Connections() {
        this.connections = new HashMap<>();
    }

    public void putConnections(ConnectionType key, Person value) {
        if (connections.containsKey(key))
            connections.get(key).add(value);
        else {
            HashSet<Person> person = new HashSet<>();
            person.add(value);
            connections.put(key, person);
        }
    }

    public boolean find(Person value) {
        for (Map.Entry<ConnectionType, HashSet<Person>> item :
                connections.entrySet()) {
            for (Person relative :
                    item.getValue()) {
                if (value.equals(relative))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<ConnectionType, HashSet<Person>> item :
                connections.entrySet()) {
            sb.append(item.getKey()).append(": ");
            for (Person relative :
                    item.getValue()) {
                sb.append(relative.briefName()).append("; ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
