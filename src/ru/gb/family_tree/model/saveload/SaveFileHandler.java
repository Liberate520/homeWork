package ru.gb.family_tree.model.saveload;

import java.io.*;

public class SaveFileHandler implements Writing {
    private final String fileName;

    public SaveFileHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(Serializable obj) throws IOException {
        ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objOutStream.writeObject(obj);
        objOutStream.close();
    }
}