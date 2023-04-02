package oop_1;

import java.io.*;
// класс реализующий чтение и запись объектов
public class FileHandler implements Writable, Serializable {
    // обработка исключений при записи объектов
    @Serial
    private void writeObject(ObjectOutputStream obj) throws IOException {
        obj.defaultWriteObject();
    }
    // обработка исключений при чтении объектов
    @Serial
    private void readObject(ObjectInputStream obj) throws IOException, ClassNotFoundException {
        obj.defaultReadObject();
    }
    // метод сериализации
    @Override
    public void save(GeoTree tree) {
        try (FileOutputStream fos = new FileOutputStream("GeoTree.out")) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(tree);
            out.close();
            System.out.println("Сериализовано!");
        } catch (Exception e) {
            System.out.println("Oops! Есть проблемы!");
        }
    }
    // метод десериализации
    @Override
    public Object read() {
        try (FileInputStream fis = new FileInputStream("GeoTree.out")) {
            GeoTree tree = new GeoTree();
            ObjectInputStream in = new ObjectInputStream(fis);
            tree = (GeoTree) in.readObject();
            in.close();
            System.out.println("Десериализовано!");
            return tree;
        } catch (Exception e) {
            System.out.println("Oops! Есть проблемы!");
            return null;
        }
    }
}