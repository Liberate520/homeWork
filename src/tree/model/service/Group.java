package tree.model.service;

import tree.model.human.Human;

public interface Group<T> extends Iterable<T> {
    boolean addHuman(T human);
    void sortByName();
    void sortByAge();
    Human getByName(String name);
}
