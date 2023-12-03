package io;
import java.io.*;

import model.GenealogyTree;

public class FileHandler implements FileWritableReadable {
    @Override
    public void writeToFile(String filename, GenealogyTree genealogyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(genealogyTree);
        }
    }

    @Override
    public GenealogyTree readFromFile(String filename) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (GenealogyTree) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
