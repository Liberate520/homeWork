package group;
import java.util.List;


/**
 * GroupInterface
 */
public interface Groupable<T> extends Iterable<T>{

    void addPerson(T t);
    List<T> getPersonList();
    T getPersonByName(String name);
    void findPerson(String name);
    void sortByName(); 
    void sortByAge();
    void sortById();
    void sortByGenderd();
    }
    