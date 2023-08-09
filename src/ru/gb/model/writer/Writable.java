package ru.gb.model.writer;

import ru.gb.model.family_tree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;

public interface Writable<T> {
    void save(T familyTree) throws IOException;
    T load() throws IOException, ClassNotFoundException;
}
