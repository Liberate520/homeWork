package model.fileManage;


import model.fileManage.interfaces.Loadable;
import model.fileManage.interfaces.Savable;

import java.io.*;


public class FileManager implements Savable, Loadable {


    private String filePath;

    /**
     * Конструктор класса FileManager.
     *
     * @param filePath путь к файлу для сохранения и загрузки
     */
    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void setFilePath(String filePath) {
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


    @Override
    public Object loadFile() {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            System.out.println("load is done");
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error uploading file");
        }
        return null;
    }
}
