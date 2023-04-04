package tree;
import java.util.List;

public interface Tree<E> extends Iterable<E> {
    void addpeople(E h, E mh, E fh);

    E findHuman(String str, E nl);

    List<E> getPeople();
}
