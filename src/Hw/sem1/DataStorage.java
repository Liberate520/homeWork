package Hw.sem1;

import java.io.*;


interface DataStorage<T> {
    void saveToFile(T data, String filename) throws IOException;
    T loadFromFile(String filename) throws IOException, ClassNotFoundException;
}


class FileHandler<T> implements DataStorage<T> {
    @Override
    public void saveToFile(T data, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        }
    }

    @Override
    public T loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (T) ois.readObject();
        }
    }
}