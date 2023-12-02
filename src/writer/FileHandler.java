package writer;

import java.io.*;

public class FileHandler implements Writable {

    public void writeObject(Object o, String fileName) {
        ObjectOutputStream objectOutputStream;

        {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
                objectOutputStream.writeObject(o);
                objectOutputStream.close();
                System.out.println("Запись прошла успешно");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Object readObject(String fileName) {
        ObjectInputStream objectInputStream;

        {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
                return objectInputStream.readObject();


            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
