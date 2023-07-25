package com.britenight.Utils;

import java.io.*;

public abstract class OperationsWithFile {
    public static void saveToFile(Serializable serializable, String path) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(serializable);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static Object readFromFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object result = objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        return result;
    }
}
