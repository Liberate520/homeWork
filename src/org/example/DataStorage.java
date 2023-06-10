package org.example;


import java.io.Serializable;

public interface DataStorage {
    void saveData(GenealogicalTree tree, String fileName);
    GenealogicalTree loadData(String fileName);
}