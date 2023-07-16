package ru.gb.family_tree.model.saveload;

import java.io.IOException;

public interface Readable {
    public Object read() throws IOException, ClassNotFoundException;
}
