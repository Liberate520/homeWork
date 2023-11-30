package ru.gb.family_tree.writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable,String filePath);
    Object load(String filePath);
}
