package faminly_tree.tree;

import faminly_tree.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface FamiliItem<E> {
    int getId();
    void setId(int id);
    int getAge();
    String getName();
    String getSurname();
    String getPatronymic();
    LocalDate getBirth();
    Gender getGender();
    E getMother();
    E getFather();
    List<E> getChildren();
}
