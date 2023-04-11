package familyTree;

import member.Member;

import java.util.List;

public interface FTree<E extends Member> extends Iterable<E> {
    void addPerson(E person);

    List<E> getPersonsList();
}