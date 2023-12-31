package ru.gb.writable;

import ru.gb.node.FamilyTree;
import ru.gb.node.TreeItem;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface Writable<E extends TreeItem<E>> extends Serializable {
    void save(Serializable serializable) throws IOException;

    List<FamilyTree<E>> loadFamilyTree() throws IOException, ClassNotFoundException;
}