package creatures;


import java.time.LocalDate;
import java.util.List;

public interface Creature<T> {


    String getName();

    LocalDate getBirthDate();

    boolean setFather(T father);

    boolean isInTree();

    List<T> getChildren();

    void setChildren(T child);

    boolean setMother(T mother);

    boolean setSpouse(T o);

    <E extends Creature<E>> E getSpouse();

    <E extends Creature<T>> T getFather();

    <E extends Creature<T>> T getMother();

    void setInTree();
}
