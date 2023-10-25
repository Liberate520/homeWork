package genealogy_tree.writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable{
    private String fileName;

    public FileHandler(String fileName){
        this.fileName = fileName;
    }

    public Boolean SaveObject(Serializable object){
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object LoadObject(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            Serializable object = (Serializable) objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Object();
    }
}
