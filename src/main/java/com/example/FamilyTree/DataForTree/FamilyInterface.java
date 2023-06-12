package com.example.FamilyTree.DataForTree;

import java.util.Date;

public interface FamilyInterface<T> {
    Gender getGender();
    Date getBirthday();
    String getName();
    int getPuberty();
    T getObject();
}
