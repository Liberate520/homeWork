package writer;

import java.io.*;

public class FileHandler implements Writable {
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public void writeObject(Object o, String fileName) {


        {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
                objectOutputStream.writeObject(o);
                System.out.println("Запись прошла успешно");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Object readObject(String fileName) {
        {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
                return objectInputStream.readObject();


            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void close(){
        try {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
