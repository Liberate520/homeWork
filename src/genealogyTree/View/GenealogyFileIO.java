package View;

import java.io.*;

import model.GenealogyTree;

public class GenealogyFileIO {
    public void saveToFile(String filePath, GenealogyTree tree) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(tree);
            System.out.println("Дерево успешно сохранено в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении дерева в файл: " + e.getMessage());
        }
    }

    public GenealogyTree loadFromFile(String filePath) {
        GenealogyTree tree = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            tree = (GenealogyTree) inputStream.readObject();
            System.out.println("Дерево успешно загружено из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке дерева из файла: " + e.getMessage());
        }
        return tree;
    }
}
