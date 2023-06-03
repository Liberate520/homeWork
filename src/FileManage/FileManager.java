package FileManage;


import FamilyTrees.FamilyTree;

import java.io.*;

/**
 * Класс, реализующий интерфейс Saveable для сохранения и загрузки семейного древа в файл.
 */
public class FileManager implements Savable, Loadable {


    private String filePath;

    /**
     * Конструктор класса FileManager.
     *
     * @param filePath путь к файлу для сохранения и загрузки семейного древа
     */
    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Сохраняет семейное древо в файл.
     *
     * @param
     */
    @Override
    public void saveFile(Object object) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println("Export error");
        }
    }

    /**
     * Загружает семейное древо из файла.
     *
     * @return загруженное семейное древо
     */
    @Override
    public FamilyTree loadFile() {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (FamilyTree) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error uploading file");
        }
        return null;
    }
}
