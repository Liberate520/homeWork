package ru.home.familyTree;

import java.io.Serializable;

public interface Writeble {

    public void write(Serializable serializable, String filePath);
    Object read(String file);
}
