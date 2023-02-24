package org.example.file;

import org.example.Tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileOperable {
    void write(Tree tree) throws IOException;
    Tree read(String nameFile) throws FileNotFoundException;
}
