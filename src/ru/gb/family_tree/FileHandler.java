package ru.gb.family_tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler implements Writable, Readable {
    private String fileName;
    private ObjectOutputStream objOutStream;
    private ObjectInputStream objInputStream;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public void writeObject(Writable obj) throws IOException, FileNotFoundException {
        objOutStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objOutStream.writeObject(obj);
        objOutStream.close();
    }

    public Readable readObject() throws IOException, FileNotFoundException, ClassNotFoundException {
        objInputStream = new ObjectInputStream(new FileInputStream(fileName));
        Readable restored = (Readable) objInputStream.readObject();
        objInputStream.close();
        return restored;
    }
}