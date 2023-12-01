package ru.gb.family_tree.model.writer;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {

    boolean write (Serializable serializable, String filepath);
    Object read (String filepath) throws IOException;

}

