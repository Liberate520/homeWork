package ru.gb.family_tree.model.familytree.serialization;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
