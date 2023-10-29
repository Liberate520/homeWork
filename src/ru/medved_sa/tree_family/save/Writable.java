package ru.medved_sa.tree_family.save;

import java.io.Serializable;

public interface Writable {
    boolean saveFile(Serializable serializable);
    Object readFile();

}
