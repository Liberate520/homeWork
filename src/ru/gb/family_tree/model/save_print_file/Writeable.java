package ru.gb.family_tree.model.save_print_file;
import java.io.Serializable;

public interface Writeable {

    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
