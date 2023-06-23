package serializer;

import tree.FamilyTree;
import java.io.*;

public class TreeSerializer implements Serializer{
    private String filePath;

    public TreeSerializer(String filePath) {
        this.filePath = filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void save(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения файла: " + e.getMessage());
        }
    }

    public FamilyTree load(String fileName) {
        FamilyTree tree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            tree = (FamilyTree) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Ошибка загрузки из файла: " + e.getMessage());
        }
        return tree;
    }

}
