package Operations;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.Human;

public class FileHandler implements recording, Serializable {

    public FileHandler() {
    }

    @Override
    public void save(List<Human> list) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("human.out"));
        for (Human person : list) {
            objectOutputStream.writeObject(person);
        }
        objectOutputStream.close();

    }

    @Override
    public Object read() throws FileNotFoundException, IOException, ClassNotFoundException {
        List<Object> readedHumans = new ArrayList<>();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("human.out"));
        while (true) {
            try {
                readedHumans.add(objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        objectInputStream.close();
        return readedHumans;
    }

}
