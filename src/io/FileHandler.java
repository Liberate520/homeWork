package io;
import java.io.*;
import model.Person;
import io.FileHandler;

import java.io.IOException;
import model.GenealogyTree;

public class FileHandler implements FileWritableReadable {
    @Override
    public void writeToFile(String filename, GenealogyTree<Person> genealogyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(genealogyTree);
        }
    }

    @Override
    public GenealogyTree<Person> readFromFile(String filename) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (GenealogyTree<Person>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
