package model.repository;

import java.io.*;

public class FileHandler implements FileService {
    private final String path;
    public FileHandler(String path){
        this.path = path;
    }

    @Override
    public  Serializable read()  {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path));
            Serializable object = (Serializable)stream.readObject();
            stream.close();
            return object;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void save(Serializable object) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(object);
            stream.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
