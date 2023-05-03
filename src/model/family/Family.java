package model.family;

import java.util.List;

public interface Family<E> {
    void add(E human);

    void delete(Integer id);

    String showTree(Integer id);

    List<E> getHumanList();

    int getId();

}
