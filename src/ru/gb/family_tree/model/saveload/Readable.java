package ru.gb.family_tree.model.saveload;

import java.io.IOException;

public interface Readable<T> {
    T read(Reading<T> handler) throws IOException, ClassNotFoundException;
}