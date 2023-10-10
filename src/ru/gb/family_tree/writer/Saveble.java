package ru.gb.family_tree.writer;

import java.io.Serializable;

public interface Saveble {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);

}
