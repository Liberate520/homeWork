package io;

import java.io.*;

import model.GenealogyTree;
import model.FamilyMember;

// Класс для записи и чтения из файла
public class FileHandlerImpl implements FileHandler {
    public <T extends FamilyMember> void writeToFile(String filename, GenealogyTree<T> genealogyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(genealogyTree);
        }
    }

    public <T extends FamilyMember> GenealogyTree<T> readFromFile(String filename) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (GenealogyTree<T>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}