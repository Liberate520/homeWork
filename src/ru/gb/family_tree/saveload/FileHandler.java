package ru.gb.family_tree.saveload;

import java.io.*;

public class FileHandler implements Writable, Readable {
    private String fileName;
    private ObjectOutputStream objOutStream;
    private ObjectInputStream objInputStream;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public Object read() throws IOException, ClassNotFoundException {
        objInputStream = new ObjectInputStream(new FileInputStream(fileName));
        Object restored = (Object) objInputStream.readObject();
        objInputStream.close();
        return restored;
    }

    @Override
    public void write(Serializable obj) throws IOException {
        objOutStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objOutStream.writeObject(obj);
        objOutStream.close();
    }
}