package ru.gb.family_tree.model.saveload;

import java.io.IOException;

public interface Reading<T> {
    T read() throws IOException, ClassNotFoundException;
}