package org.example;

import java.io.*;

public class FileDataStorage implements DataStorage<GenealogicalTree<Person>> {

    @Override
    public void saveData(GenealogicalTree<Person> data, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public GenealogicalTree<Person> loadData(String fileName) throws ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            GenealogicalTree<Person> data = (GenealogicalTree<Person>) ois.readObject();
            System.out.println("Data loaded successfully.");
            return data;
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return null;
    }
}