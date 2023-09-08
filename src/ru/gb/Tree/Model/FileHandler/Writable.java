package ru.gb.Tree.Model.FileHandler;

import ru.gb.Tree.Model.FamilyTree.Tree;
import ru.gb.Tree.Model.Human.Human;

public interface Writable {
    void saveFile(Tree<Human> tree);
    Tree<Human> readFile();
}