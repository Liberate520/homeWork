package ru.gb.family_tree.Servise;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface SaveLoading {
    Object save(Serializable serializable, String path) throws IOException, ClassNotFoundException;
    Object loading(String path) throws IOException, ClassNotFoundException;
}
