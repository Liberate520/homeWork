package ru.java_oop.family_tree.family_tree;

import ru.java_oop.family_tree.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem <E extends FamilyTreeItem<?>> {
    String getName();
    int getAge();
    long getId();
    void setId(long id);
    void setParents(List<E> parents);
    void addParent(FamilyTreeItem<?> parent);
    List<E> getParents();
    List<E> getChildren();
    void addChild(FamilyTreeItem<?> child);
    E getSpouse();
    void setSpouse(E spouse);
    Gender getGender();
    void setChildren(List<E> parents);
    E getFather();
    E getMother();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
}
