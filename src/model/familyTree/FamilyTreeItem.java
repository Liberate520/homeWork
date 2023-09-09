package model.familyTree;

import model.human.Gender;

import java.util.List;

public interface FamilyTreeItem<T> {
    int getAge();
    void setId(long Id);
    Gender getGender();
    String getName();
    T getFather();
    void setFather(T human);
    T getMother();
    void setMother(T human);
    List<T> getChildren();

    boolean addChild(T child);

    long getId();

    T getSpouse();

    void setSpouse(T human);
}
