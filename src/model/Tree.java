package model;

import java.io.Serializable;
import java.util.List;

public interface Tree<E> extends Iterable<E>, Serializable {
    void addHuman(E human);
    List<E> getHumanList();
}
