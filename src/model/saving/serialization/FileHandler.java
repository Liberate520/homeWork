package model.saving.serialization;

import java.io.*;

public class FileHandler implements Serializable, Writable{
    public void writeObject(Serializable serializable, String fileLink){

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(fileLink));
            out.writeObject(serializable);
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public Object readObject(String fileLink){

        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(fileLink));
            return in.readObject();
        } catch (Exception e) {
            System.out.println("Файла нет");
            return null;
        }
    }
}
