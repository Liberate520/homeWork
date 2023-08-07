package Model.Service.writer;

import java.io.*;
import java.io.FileNotFoundException;

public class FileHandler implements Writable {
    @Override
    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        }  catch (FileNotFoundException e){
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
