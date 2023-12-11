package ru.gb.family_tree_homework.family_tree;

import ru.gb.family_tree_homework.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<E> extends Serializable {
    void setId(long id);
    long getId();
    Integer getAge();
    void setGender(Gender gender);
    Gender getGender();
    E getFather();
    E getMother();
    boolean addChild(E familyMember);
    boolean addParent(E familyMember);
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<E> getParents();
    List<E> getChildren();
    void setSpouse(E human);
    E getSpouse();
}
