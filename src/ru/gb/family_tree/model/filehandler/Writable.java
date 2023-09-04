package ru.gb.family_tree.model.filehandler;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;

import java.io.Serializable;

public interface Writable{
    boolean write(FamilyTree<Human> tree);
    FamilyTree<Human> read();
    void setFilePath(String filePath);
}
