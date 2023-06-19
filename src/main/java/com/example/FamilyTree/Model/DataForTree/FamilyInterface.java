package com.example.FamilyTree.Model.DataForTree;

import java.util.Date;
import java.util.List;

public interface FamilyInterface<T> {
    Gender getGender();
    Date getBirthday();
    String getName();
    int getPuberty();
    T getObject();
    List getListFields();
    void setName(String name);
    void setBirthday(Date birthday);
    void setGender(Gender gender);
}
