package tree.model.geneticTree;

import tree.model.human.Human;

public interface GroupTree<T> extends Iterable<T> {
    boolean addHuman(T human);
    void sortByName();
    void sortByAge();
    Human getByName(String name);
}
