package tree.service;

import tree.human.Human;

import java.util.List;

public interface Group<T> extends Iterable<T> {
    void addHuman(T human);
    void sortByName();
    void sortByAge();
    Human getByName(String name);
}
