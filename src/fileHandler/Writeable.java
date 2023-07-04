package fileHandler;

import human.GenealogyTree;

import java.io.IOException;
import java.util.List;
public interface Writeable {
    void saveToFile(String fileName, GenealogyTree tree) throws IOException;
    GenealogyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}