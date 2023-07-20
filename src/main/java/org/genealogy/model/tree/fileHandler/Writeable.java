package org.genealogy.model.tree.fileHandler;

import org.genealogy.model.tree.GenealogyTree;
import org.genealogy.model.tree.TreeItem;

import java.io.IOException;

public interface Writeable {
    void saveToFile(String fileName, GenealogyTree tree) throws IOException;
    GenealogyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
