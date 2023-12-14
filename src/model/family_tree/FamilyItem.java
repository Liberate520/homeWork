package model.family_tree;

import model.human.Gender;

import java.io.Serializable;

public interface FamilyItem<T> extends Serializable,Comparable<T> {
    String getName();
    int getAge();

    void setId(long l);

    long getId();

    Gender getGender();

    String getChild();
}
