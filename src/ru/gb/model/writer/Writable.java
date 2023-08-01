package ru.gb.model.writer;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void save(Serializable object) throws IOException;
    Object load() throws IOException, ClassNotFoundException;
}
