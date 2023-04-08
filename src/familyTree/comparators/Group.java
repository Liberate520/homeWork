package familyTree.comparators;

import java.util.List;

public interface Group<E> extends Iterable<E> {

    void addHuman(E human);

    void addPet(E pets);



    List<E> getHumanList();
    List<E> getPetList();



   // List<E> getChildList();


    String getName();

    String getSurname();

    String getInfo();

    E getFather();

     E getMother();

    void addChild(E human);
}
