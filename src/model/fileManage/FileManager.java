package model.fileManage;


import model.familyTrees.FamilyTree;
import model.fileManage.interfaces.Loadable;
import model.fileManage.interfaces.Savable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

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
     * Сохраняет объект в файл
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
     * Загружает объект из файла.
     *
     * @return загруженный объект
     */
    @Override
    public FamilyTree loadFile() {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            System.out.println("load is done");
            return (FamilyTree) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error uploading file");
        }
        return null;
    }
}
