package ru.gb.family_tree.filehandler;

import java.io.Serializable;

public interface Writable{
    boolean write(Serializable serializable);
    Object read();
    void setFilePath(String filePath);
}
