package ru.gb.family_tree;
import java.io.Serializable;

public interface Writeable {

    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
