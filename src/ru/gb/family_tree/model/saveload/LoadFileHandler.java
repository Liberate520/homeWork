package ru.gb.family_tree.model.saveload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadFileHandler<T> implements Reading<T> {
    private final String fileName;

    public LoadFileHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public T read() throws IOException, ClassNotFoundException {
        ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(fileName));
        T restored = (T) objInputStream.readObject();
        objInputStream.close();
        return restored;
    }
}
