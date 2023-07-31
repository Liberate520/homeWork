package familyTree;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Класс типа данных, в котором хранятся все родственные связи конкретного человека.
 */
public class Connections<T extends TreeNode<T>> implements Serializable {
    private HashMap<ConnectionType, HashSet<T>> connections;

    public Connections(ConnectionType key, T person) {
        HashMap<ConnectionType, HashSet<T>> connection = new HashMap<>();
        HashSet<T> set = new HashSet<>();
        set.add(person);
        connection.put(key, set);
        this.connections = connection;
    }

    public Connections() {
        this.connections = new HashMap<>();
    }

    public void putConnections(ConnectionType key, T value) {
        if (connections.containsKey(key))
            connections.get(key).add(value);
        else {
            HashSet<T> person = new HashSet<>();
            person.add(value);
            connections.put(key, person);
        }
    }

    public boolean find(T value) {
        for (Map.Entry<ConnectionType, HashSet<T>> item :
                connections.entrySet()) {
            for (T relative :
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
        for (Map.Entry<ConnectionType, HashSet<T>> item :
                connections.entrySet()) {
            sb.append(item.getKey()).append(": ");
            for (T relative :
                    item.getValue()) {
                sb.append(relative.briefName()).append("; ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
