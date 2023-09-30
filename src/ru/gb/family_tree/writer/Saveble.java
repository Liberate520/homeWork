package ru.gb.family_tree.writer;

import ru.gb.family_tree.Tree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;

public interface Saveble {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);

}
