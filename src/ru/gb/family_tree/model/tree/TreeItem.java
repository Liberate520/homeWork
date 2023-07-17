package ru.gb.family_tree.model.tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeItem<T> extends Serializable {
    int getId();
    void setId(int i);
    String getName();
    int getAge();
    String getSurname();
    String getNumPassport();

    LocalDate getBirthday();
    void addKid(T human);
    void addParent(T human);
    void addPartner(T human);
    List<T> getPartner();
    List<T> getParents();
    List<T> getKids();
    T getFather();
    T getMother();

}
