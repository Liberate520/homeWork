package org.example;

import java.io.IOException;

interface DataStorage<T> {
    void saveData(T data, String fileName);
    T loadData(String fileName) throws ClassNotFoundException;
}