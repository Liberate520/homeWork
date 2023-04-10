package tree;

import human.Human;

import java.util.List;

public interface Family<E extends Human> extends Iterable<E> {
    List<E> getMembers();

}
