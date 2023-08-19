package model.family_tree;

import java.time.LocalDate;
import java.util.List;

import model.person.Gender;

public interface TreeNode<T> {
    void setId(int id);
    int getId();
    T getFather();
    T getMother();
    boolean addChild(T person);
    boolean addFather(T person);
    boolean addMother(T person);
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<T> getParents();
    List<T> getChildren();

    Gender getGender();

    int getAge();
}
