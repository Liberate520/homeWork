package model.creatures;


import java.time.LocalDate;
import java.util.List;

public interface Creature<T> extends Comparable<Object> {


    String getName();

    LocalDate getBirthDate();

    boolean setFather(T father);

    boolean isInTree();

    List<T> getChildren();

    void setChildren(T child);

    boolean setMother(T mother);

    boolean setSpouse(T o);

    Integer getId();

    <E extends Creature<T>> E getSpouse();

    <E extends Creature<T>> E getFather();

    <E extends Creature<T>> E getMother();

    void setInTree();
}
