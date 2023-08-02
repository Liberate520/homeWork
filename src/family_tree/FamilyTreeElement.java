package family_tree;

import human.Human;

import java.time.LocalDate;

public interface FamilyTreeElement<E> {
    void marry(E element);
    void addChild(E element);
    void addParent(E element);
    String getName();
    LocalDate getBirthDay();
}
