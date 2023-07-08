package faminly_tree.save_in_file;

import faminly_tree.human.Human;
import faminly_tree.tree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;

public interface WriteAndRead extends Serializable {
    void write(String path, Human human) throws IOException;
    void write(String path, FamilyTree tree) throws IOException;
    Human readHuman(String path) throws IOException, ClassNotFoundException;
    FamilyTree readTree(String path) throws IOException, ClassNotFoundException;
}
