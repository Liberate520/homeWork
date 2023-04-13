import java.util.ArrayList;

public interface Group<E extends Human> extends Iterable<E> {
    void add(E human);
    ArrayList<E> getHumansList();
    E getHumanByName(String name);
}
