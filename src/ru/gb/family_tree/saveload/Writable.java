package ru.gb.family_tree.saveload;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    public void write(Serializable obj) throws IOException;
}
