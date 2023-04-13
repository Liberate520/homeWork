package familyTreeApi.handler;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;

public class FileHandler<E> implements Writable<E> {

    @Override
    public void save(E e, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(e);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public E read(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(fileName))) {
            E result = (E) objectInputStream.readObject();
            objectInputStream.close();
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}