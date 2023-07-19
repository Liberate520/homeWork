package org.genealogy.model.tree;

public interface TreeItem {
    String getName();
    int getAge();

    int getId();

    void setDateOfBirth(int day, int month, int year);
}