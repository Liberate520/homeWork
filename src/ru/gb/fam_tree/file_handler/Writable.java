package ru.gb.fam_tree.file_handler;

import java.io.Serializable;


public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
    /*
    void writeFamilyTree(Serializable serializable, String filePath);
    Serializable readFamilyTree(String filePath);

     */
}