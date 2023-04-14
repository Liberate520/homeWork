package Tree;

import java.util.List;

public interface Tree<E> extends Iterable<E>{
    void addPerson(E person);
    List<E> getPersonList();
    boolean add(E person);
    String getInfo();
}
