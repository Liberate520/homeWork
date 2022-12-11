package service.IO;


import java.io.*;

/*
Класс для записи и считывания объектов
 */
public class StreamWork implements IO {
    public <E> void toFile(E element, String path) throws IOException {
        try (OutputStream outStream = new FileOutputStream(path)) {
            ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
            objectOutStream.writeObject(element);
            outStream.close();
            System.out.println("Saved successfully");
        }
    }

    public Object fromFile(String path) throws Exception {
        try (FileInputStream reader = new FileInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(reader);
            Object element = objectInputStream.readObject();
            System.out.println("Loaded successfully");
            return element;
        }
    }
}