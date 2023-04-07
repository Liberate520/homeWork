package human;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public interface Animal<E> extends Iterable<E>{

    void addHuman(E human);

    List<E> getHumanList();

    String getName();

    String getSurname();

    E getFather();
    void addChild(E child);
    Human getMother();
    char[] getInfo();


}
