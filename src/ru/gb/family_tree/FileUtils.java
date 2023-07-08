package ru.gb.family_tree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtils {
    public static boolean saveToFile(String fileName, FamilyTree familyTree) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(familyTree);
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении дерева в файл.");
            e.printStackTrace();
            return false;
        }
    }

    public static FamilyTree loadFromFile(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
            return familyTree;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке дерева из файла.");
            e.printStackTrace();
            return null;
        }
    }
}
