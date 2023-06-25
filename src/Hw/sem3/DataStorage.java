package Hw.sem3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

interface DataStorage<T> {
    void saveData(List<T> data, String filename);

    List<T> loadData(String filename);
}

// Класс для сохранения и загрузки данных в файл
class FileHandler<T> implements DataStorage<T> {
    @Override
    public void saveData(List<T> data, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(data);
            System.out.println("Data saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    @Override
    public List<T> loadData(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            List<T> data = (List<T>) inputStream.readObject();
            System.out.println("Data loaded from file: " + filename);
            return data;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}