package ru.gb.family_tree.family_tree.model.writer;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable,String filePath);
    Object load(String filePath);
}