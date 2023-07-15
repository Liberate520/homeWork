package ru.java_oop.family_tree.model.file_handler;

import java.io.*;

public class FileHandler implements SavableAndReadable {
    private ObjectOutputStream objOutputStream;
    private ObjectInputStream objInputStream;
    private String filePath;

    public FileHandler(String filePath) {
        this.setFilePath(filePath);
    }

    public FileHandler() {
        this("backup.out");
    }

    @Override
    public void writeObjToFile(Object obj) {
        try {
            this.objOutputStream = new ObjectOutputStream(new FileOutputStream(this.getFilePath()));
            this.objOutputStream.writeObject(obj);
            this.objOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object readObjFromFile() {
        try {
            this.objInputStream = new ObjectInputStream(new FileInputStream(this.getFilePath()));
            Object result = this.objInputStream.readObject();
            this.objInputStream.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
