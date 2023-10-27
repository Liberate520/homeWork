package ru.medved_sa.tree_family.save;

import java.io.Serializable;

public interface Writable {
    String filePath = "src/ru/medved_sa/tree_family/save/familyTree.out";

    boolean saveFile(Serializable serializable, String filePath);

    Object readFile(String filePath);

}
