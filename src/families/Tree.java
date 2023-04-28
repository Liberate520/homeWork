package families;

import essence.Essence;

import java.io.IOException;
import java.util.List;

public interface Tree<T extends Essence<T>>{
    void addMember(T t);
    List<T> getPeopleList();
    List<T> getChildren(T t);
    List<T> getParents(T t);
    List<T> getDescendants(T t);
    List<T> getAncestors(T t);
    List<T> getRelatives(T t);
    T searchByName(String name);

    void setChildren(T parent, T child);
    void save(Writable<T> writable) throws IOException;
    void getInfo();
}
