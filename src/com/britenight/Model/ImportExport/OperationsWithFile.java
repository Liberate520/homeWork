package com.britenight.Model.ImportExport;

import java.io.*;

public abstract class OperationsWithFile {
    public static void saveToFile(Serializable serializable, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readFromFile(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
