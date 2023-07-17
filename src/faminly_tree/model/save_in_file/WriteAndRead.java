package model.save_in_file;

import model.human.Human;
import model.tree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;

public interface WriteAndRead extends Serializable {
    void write(String path, Human human) throws IOException;
    void write(String path, FamilyTree tree) throws IOException;
    Human readHuman(String path) throws IOException, ClassNotFoundException;
    FamilyTree readTree(String path) throws IOException, ClassNotFoundException;
}