package ru.java_oop.family_tree.file_handler;

import java.io.*;

public class FileHandler implements SavableAndReadable {
    private ObjectOutputStream objOutputStream;
    private ObjectInputStream objInputStream;
    private String fileName;

    public FileHandler(String fileName) {
        this.setFileName(fileName);
    }

    public FileHandler() {
        this("backup.out");
    }

    @Override
    public void writeObjToFile(Object obj) throws IOException {
        this.objOutputStream = new ObjectOutputStream(new FileOutputStream(this.getFileName()));
        this.objOutputStream.writeObject(obj);
        this.objOutputStream.close();
    }

    @Override
    public Object readObjFromFile() throws IOException, ClassNotFoundException {
        this.objInputStream = new ObjectInputStream(new FileInputStream(this.getFileName()));
        Object result = this.objInputStream.readObject();
        this.objInputStream.close();
        return result;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
