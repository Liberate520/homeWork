package ru.java_oop.family_tree.file_handler;

import java.io.*;

public class FileHandler implements SavableAndReadable {
    private ObjectOutputStream objOutputStream;
    private ObjectInputStream objInputStream;
    private String fileName;
    private Object obj;

    public FileHandler(String fileName, Object obj) {
        this.setFileName(fileName);
        this.setObj(obj);
    }

    public FileHandler(Object obj) {
        this("backup.out", obj);
    }

    public FileHandler() {
        this(null);
    }

    @Override
    public void writeObjToFile() throws IOException {
        this.objOutputStream = new ObjectOutputStream(new FileOutputStream(this.getFileName()));
        this.objOutputStream.writeObject(this.getObj());
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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
