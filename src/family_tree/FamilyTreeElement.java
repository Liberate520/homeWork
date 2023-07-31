package family_tree;

import human.Human;

import java.time.LocalDate;

public interface FamilyTreeElement<E> {
    void marry(E element);
    void addChild(E element);
    void addParent(E element);
    String getName();

    void marry(Human partner);

    void addChild(Human child);

    void addParent(Human parent);

    LocalDate getBirthDay();
}
