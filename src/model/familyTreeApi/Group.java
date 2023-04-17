package model.familyTreeApi;
import java.util.ArrayList;

public interface Group<E> extends Iterable<E> {
    void add(E human);
    ArrayList<E> getHumansList();
    E getHumanByName(String name);
    void delete(E human);
    void deleteByName(String name, String lastName);
}
