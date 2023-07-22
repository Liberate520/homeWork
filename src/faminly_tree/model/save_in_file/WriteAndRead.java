package faminly_tree.model.save_in_file;

import faminly_tree.model.human.Human;
import faminly_tree.model.tree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;

public interface WriteAndRead<E extends Serializable> {
    void write(String path, E obj) throws IOException;
    Object readTree(String path) throws IOException, ClassNotFoundException;
}
