package faminly_tree.model.tree;

import faminly_tree.model.human.Gender;
import faminly_tree.model.human.Human;

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
    void setFather(Human father);
    void setMother(Human mother);
}
