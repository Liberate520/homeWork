package model;

import java.util.List;

public interface Tree<E> extends Iterable<E>{
    void addHuman(E human);
    List<E> getHumanList();

    void sortByName();

    void sortByBirthDate();

}
