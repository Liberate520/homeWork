package ru.medved_sa.tree_family.model.familyTree;

import java.io.Serializable;
import java.util.List;

public interface EntityCreation<T> extends Serializable {
    int getAge();

    void addChild(T entity);

    void addParent(T entity);

    long getId();

    void setId(long id);

    String getFirstName();

    T getMother();

    T getFather();

    T getSpouse();

    void setSpouse(T entity);

    String getSpouseInfo();

    List<T> getParents();

    List<T> getChildren();


}
