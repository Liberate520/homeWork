package ru.gb.Tree.FileHandler;

import ru.gb.Tree.FamilyTree.Tree;

public interface Writable {
    void saveFile(Tree tree, String path);
    Object readFile(String path);
}