package org.example.model.file;

import org.example.model.Tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileOperable {
    void write(Tree tree) throws IOException;
    Tree read(String nameFile) throws FileNotFoundException;
}
