package familyTree.comparators;

import java.util.List;

public interface Group<T> extends Iterable<T> {

    void addHuman(T human);

    List<T> getHumanList();

   // List<E> getChildList();


    String getName();

    String getSurname();
    String getInfo();
   // E getFather();
   //  E getMother();

    void addChild(E human);
}
