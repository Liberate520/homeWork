package familytree.model;

import java.io.*;

public class InputOutputFile implements IOFile {
@Override
public void saveFamilyTree(Familytree familytree, String fileName) {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
        outputStream.writeObject(familytree);
        System.out.println("Генеалогическое древо сохранено в файл " + fileName);
    } catch (IOException e) {
        System.out.println("Ошибка при сохранении генеалогического древа: " + e.getMessage());
    }
}

    @Override
    public Familytree loadFamilyTree(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Familytree familyTree = (Familytree) inputStream.readObject();
            System.out.println("Генеалогическое древо загружено из файла " + fileName);
            return familyTree;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке генеалогического древа: " + e.getMessage());
            return null;
        }
    }
}
