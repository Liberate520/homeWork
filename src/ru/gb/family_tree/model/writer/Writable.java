package ru.gb.family_tree.model.writer;

import java.io.Serializable;

public interface Writable {
    boolean saveFile(Serializable serializable, String filePath);
    Object readFile(String filePath);
}
