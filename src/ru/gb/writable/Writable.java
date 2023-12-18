package ru.gb.writable;

import ru.gb.node.FamilyTree;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface Writable extends Serializable {
    void save(Serializable serializable) throws IOException;

    List<FamilyTree> loadFamilyTree() throws IOException, ClassNotFoundException;
}