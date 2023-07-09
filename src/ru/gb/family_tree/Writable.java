package ru.gb.family_tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {
    public void write(Object obj) throws IOException, FileNotFoundException;
}
