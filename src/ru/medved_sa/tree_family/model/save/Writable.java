package ru.medved_sa.tree_family.model.save;

import java.io.Serializable;

public interface Writable {
    boolean saveFile(Serializable serializable);
    Object readFile();

}
