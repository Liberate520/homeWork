package org.example.model.file;

import org.example.model.Human;
import org.example.model.Tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileOperable {
    void write(Tree<Human> tree) throws IOException;
    Tree<Human> read(String nameFile) throws FileNotFoundException;
}
