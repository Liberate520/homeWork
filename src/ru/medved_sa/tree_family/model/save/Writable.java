package ru.medved_sa.tree_family.model.save;

import java.io.Serializable;

public interface Writable<E> {
    boolean saveFile(Serializable serializable, String fileName);
    E readFile(String fileName);

}
