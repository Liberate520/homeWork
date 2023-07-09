package ru.gb.family_tree.saveload;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Readable {
    public Object read() throws IOException, FileNotFoundException, ClassNotFoundException;
}
