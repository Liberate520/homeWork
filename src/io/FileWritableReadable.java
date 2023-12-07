package io;
import model.Person;
import model.GenealogyTree;
import io.FileWritableReadable;

import java.io.IOException;


public interface FileWritableReadable {
    void writeToFile(String filename, GenealogyTree<Person> genealogyTree) throws IOException;
    GenealogyTree<Person> readFromFile(String filename) throws IOException;
}
