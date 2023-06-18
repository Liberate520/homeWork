package org.example;

import java.io.*;

public class BinaryDataStorage<T> implements DataStorage<T>, Serializable {

    @Override
    public void saveData(T data, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(data);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public T loadData(String fileName) throws ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) inputStream.readObject();
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return null;
    }
}
