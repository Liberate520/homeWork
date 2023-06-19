package Hw.sem1;

import java.io.*;

public class FileHandler<T extends Serializable> implements DataStorage<T> {
    @Override
    public void saveToFile(String fileName, T data) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(data);
        }
    }

    @Override
    public T loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) inputStream.readObject();
        }
    }
}
