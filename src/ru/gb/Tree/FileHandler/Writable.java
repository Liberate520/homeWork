package ru.gb.Tree.FileHandler;

import ru.gb.Tree.FamilyTree.Tree;
import ru.gb.Tree.Human.Human;

public interface Writable {
    void saveFile(Tree<Human> tree, String path);
    Tree<Human> readFile(String path);
}