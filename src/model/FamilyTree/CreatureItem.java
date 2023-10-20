package model.FamilyTree;

import model.creature.Gender;

import java.time.LocalDate;
import java.util.List;

public interface CreatureItem<T> {
    int getAge();

    String getName();

    long getId();

    void setId(long id);

    Gender getGender();

    T getMother();

    T getFather();

    List<T> getChildren();

    void addParent(T parent);

    boolean addChildren(T child);

    T getSpouse();

    void setSpouse(T spouse);

    LocalDate getDataBirth();

    LocalDate getDataDeath();
}
