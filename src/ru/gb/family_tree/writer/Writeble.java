package ru.gb.family_tree.writer;

import java.io.Serializable;

public interface Writeble {
    boolean save(Serializable serializable, String path);
    Object read(String path);
}
